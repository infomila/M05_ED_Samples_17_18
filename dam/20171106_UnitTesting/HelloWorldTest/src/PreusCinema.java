/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BERNAT
 */
public class PreusCinema {
       
    public double getPreu( int edat, int diaSetm, boolean teCarnet) {
       
       //-------------------------------------------------
       // Assercions de dades
       if(edat<4 || edat>=150 ) throw new RuntimeException("Edat errònia");
       if(diaSetm<1 || diaSetm>7 ) throw new RuntimeException("Dia erròni");
       //-------------------------------------------------
       
       
        double preus[][]={
            {5,6,4},
            {4,5,3},
        };
        int tipusDia;
        switch(diaSetm) {
            case 3:         tipusDia = 2; break;
            case 6:case 7:  tipusDia = 1; break;
            default:        tipusDia = 0;
        }
        double descompte = 0;
        if(tipusDia==0 && teCarnet) {
            descompte = 1;
        }
        return preus[edat>=18?0:1][tipusDia]-descompte;
    }
}
