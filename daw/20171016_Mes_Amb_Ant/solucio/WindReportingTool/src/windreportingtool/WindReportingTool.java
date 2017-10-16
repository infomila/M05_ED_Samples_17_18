package windreportingtool;

import com.surf_forecast.au.WindQuery;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BERNAT
 */
public class WindReportingTool {

   /* String [] mCodisPlatges = { "Barceloneta", "Bogatell", "Cabrera", "Calade-Santa-Cristina", "Comandancia", "Desembocaduradel-Tordera", "Masnou", "Empuriabrava", "Garraf", "La-Rotonda", "Latigo", "Miami-Platja", "Montgat", "Nova-Mar-Bella-Barcelona", "Peyo-s", "Platja-de-Sant-Pol", "Playade-Premia", "Playade-Sant-Sebastia", "Port-de-Mataro", "Port-Ginesta-Castelldefels", "Roc-San-Cayetano", "Saint-Andreu-de-Llavaneres", "Sant-Marti", "Segur-de-Calafell", "Torre-Bank", "Vilassar" ,
                    "La-Salvaje","Deba","Guibeleco","Hondarribia","Islade-Izaro","Karramarro","La-Concha","Menakoz","Mundaka","Mutriku","Orio","Orrua","Pena-Roja","Playade-Aizkorri","Playade-Arrietara","Playade-Arrigunaga","Playade-Barrika","Playade-Ereaga","Playade-Gaztetape","Playade-Gros","Playade-Karraspio","Playade-Laga","Playade-Laida","Playade-Ogeia","Playade-Ondarreta_Pikua","Playade-Ondarreta_Picodel-Tenis","Plentzia","Punta-Galea","Roca-Puta","Sopelana","Zarautz","Zumaya" };
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        if(args.length<1) {
            System.out.println("> US: cal indicar el nom de l'arxiu de codis (sense incloure l'extensió)");
            return;
        }
        
        String fileName = args[0];
        Properties p = new Properties();
        
        File file = new File("data/"+fileName+".txt");
        if(!file.exists()) {
            System.out.println("ERROR: L'arxiu "+file.getAbsolutePath()+" no existeix.");
        }
        System.out.println("Processant l'arxiu "+file.getAbsolutePath());
        p.load(new FileInputStream(file));
        String platges = p.getProperty("BEACHES");
        StringTokenizer st = new StringTokenizer(platges, " ,");
        ArrayList<String> beachCodes = new ArrayList<String>();
        while(st.hasMoreTokens()) {
            beachCodes.add(st.nextToken());
        }
        ArrayList<InfoWind> infos = ferConsulta(beachCodes);
        ReportXLSX.writeReport(infos, fileName);
        
    }
    
    public static class InfoWind {
        private String mNom;
        private int mVelocity;

        public InfoWind(String mNom, int mVelocity) {
            this.mNom = mNom;
            this.mVelocity = mVelocity;
        }

        public String getNom() {
            return mNom;
        }

        public int getVelocity() {
            return mVelocity;
        }
        
    }
    private static ArrayList<InfoWind> ferConsulta(ArrayList<String> beachCodes){
        ArrayList<InfoWind> llistaPlatges = new ArrayList<>();
        try {
            ArrayList<WindQuery> consultes = new ArrayList<WindQuery>();
            for( String codi:beachCodes) {
                consultes.add( new WindQuery(codi));                
            }
            ExecutorService exs = Executors.newFixedThreadPool(8);
            List<Future<Integer>> resultats = exs.invokeAll(consultes);
            exs.shutdown();

            if(exs.awaitTermination(4, TimeUnit.MINUTES)){

                for(int i=0;i<resultats.size();i++) {
                    int vent = resultats.get(i).get();
                    InfoWind iw = new InfoWind(consultes.get(i).getCodiPlatja(), vent);
                    llistaPlatges.add(iw);
                }                    
            }            
           
        } catch (Exception ex) {
            Logger.getLogger(WindReportingTool.class.getName()).log(Level.SEVERE, null, ex);
        }          
        return llistaPlatges;
    }
    
}
