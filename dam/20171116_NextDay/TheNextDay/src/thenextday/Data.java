
package thenextday;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author BERNAT
 */
public class Data {
    public int dia, mes, anio;

    public Data(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Data{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + '}';
    }
    
    
    public static Data nextDay( Data unaData) throws Exception {
        //--------------------------------------------------------------
        //         Assercions (asserts)
        //--------------------------------------------------------------
        if(unaData==null) throw new Exception("La data no pot ser nul·la");
        if(unaData.mes<1 || unaData.mes>12)  throw new Exception("Mes erroni");
        if(unaData.anio<0  )  throw new Exception("Any erroni");
        if(unaData.dia<1 || unaData.dia>31)  throw new Exception("Dia erroni");
        
        int lon[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        int maxDia = lon[unaData.mes-1];
        if(unaData.mes==2 && 
                ((unaData.anio%4==0 && unaData.anio%100!=0 ) || unaData.anio%400==0)){
            maxDia++;
        }
        if(unaData.dia>maxDia) throw new Exception("Dia erroni");
        //--------------------------------------------------------------
        Calendar c = new GregorianCalendar(unaData.anio, unaData.mes-1, unaData.dia);
        c.add(Calendar.DATE, 1);
        Data d = new Data( 
                        c.get(Calendar.DAY_OF_MONTH),
                        c.get(Calendar.MONTH)+1,
                        c.get(Calendar.YEAR)
                );
        return d;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.dia;
        hash = 19 * hash + this.mes;
        hash = 19 * hash + this.anio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Data other = (Data) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        return true;
    }
    
    
}
