package net.iesmila.p2.utliitats;

/**
 *
 * @author BERNAT
 */
public class Utils {
    
    public boolean esParell(int numero) {
        return numero%2==0;
    }
    
    public static void main(String [] args) {
        Utils  u = new Utils();
        if(u.esParell(13)!=false) throw new RuntimeException("ERROR !");
        if(u.esParell(12)!=true) throw new RuntimeException("ERROR !");
        if(u.esParell(0)!=true) throw new RuntimeException("ERROR !");
        System.out.println("Tot ha funcionat !!!!! :-D ");
    }
}
