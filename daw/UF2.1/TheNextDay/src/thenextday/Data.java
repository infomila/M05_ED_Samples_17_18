package thenextday;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuari
 */
public class Data {
    public int dia, mes, any;

    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }
    
    
    public static Data nextDay(Data unaData) throws Exception {
        

        // asserció ( assert )
        if(unaData==null) throw new Exception("La data no pot ser nul·la");
        if( unaData.mes<1 || unaData.mes>12) throw new Exception("Mes erroni");
        if( unaData.any<0 ) throw new Exception("Any erroni");
        
        if(unaData.dia<1) throw new Exception("Dia  erroni");
        if(unaData.dia>31) throw new Exception("Dia  erroni");
        
        //------------------------------
        Calendar c = new GregorianCalendar(unaData.any,unaData.mes-1,  unaData.dia);        
        c.add(Calendar.DATE, 1);        
        //System.out.println(">>" + c);
        return new Data( 
                c.get(Calendar.DAY_OF_MONTH),
                c.get(Calendar.MONTH)+1,
                c.get(Calendar.YEAR));
        
    }

    @Override
    public String toString() {
        return "Data{" + "dia=" + dia + ", mes=" + mes + ", any=" + any + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.dia;
        hash = 89 * hash + this.mes;
        hash = 89 * hash + this.any;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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
        if (this.any != other.any) {
            return false;
        }
        return true;
    }

    
    
}
