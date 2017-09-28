
package net.iesmila.p2;

import net.iesmila.utils.Utils;

/**
 *
 * @author BERNAT
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Funcions f = new Funcions();
        int resultat = f.suma(2,3);
        
        Utils u = new Utils();
        System.out.println("13 és parell?"+u.esParell(13));                        
        
        System.out.println("Hello World: 2+3 = " +resultat);
    }
    
}
