package net.iesmila.p2;

import net.iesmila.p2.utliitats.Utils;

/**
 *
 * @author BERNAT
 */
public class HolaMon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for(int i=0;i<args.length;i++) {
            System.out.println(">"+args[i]);
        }
        
        Utils  u = new Utils();
        
        System.out.println("13 és parell? " +u.esParell(13));
        
        Funcions f = new Funcions();
        int resultat = f.suma(2,3);
        System.out.println("Hola Món 2+3 fan " + resultat);
    }
    
}
