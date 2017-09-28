package net.iesmila.utils;

/**
 *
 * @author BERNAT
 */
public class Utils {
    
    /**
     * Aquesta funció ens diu si un número és parell.
     * @param el número
     * @return true si és parell, false si és senar
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
            System.out.println("Tot va bé !");
        } else {
            System.out.println("La funció ha petat");
        }
    }
}
