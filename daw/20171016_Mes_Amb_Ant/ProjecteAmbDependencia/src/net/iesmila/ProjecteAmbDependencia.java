package net.iesmila;

/**
 *
 * @author BERNAT
 */
public class ProjecteAmbDependencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Projecte B");
        System.out.println("Generaci� d'un PDF");
     
        DemoIText.crearPdf("./tmp.pdf", "EIIIII s�c un altre projecte");
    }
    
}
