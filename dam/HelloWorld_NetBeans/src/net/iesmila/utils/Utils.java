package net.iesmila.utils;

/**
 *
 * @author BERNAT
 */
public class Utils {
    
    /**
     * Aquesta funci� ens diu si un n�mero �s parell.
     * @param el n�mero
     * @return true si �s parell, false si �s senar
     */
    public boolean esParell(int numero) {
        return numero%2==0;
    }
    
    //-------------------------------------------------
    public static void main(String[] args) {
        
        
        
        
        
        Utils u = new Utils();
        if(     u.esParell(13)==false && 
                u.esParell(12)==true &&
                u.esParell(0)==true) {
            System.out.println("Tot va b� !");
        } else {
            System.out.println("La funci� ha petat");
        }
    }
}
