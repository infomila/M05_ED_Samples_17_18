/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsanegra;

import org.junit.Test;
import static org.junit.Assert.*;
import projecte.capsanegra.Parking;

/**
 *
 * @author BERNAT
 */
public class ParkingTest {

    public ParkingTest() {
    }

    @Test
    public void testBuscaLlocLliure() {

        //-------------------------------------------------------
        //              FORES DE RANG
        //-------------------------------------------------------
        Parking p = new Parking();
        {
            int[] placesCodiClient = {0, 0};
            int[] placesLongitudCm = {300, 600};
            boolean[] placesOcupades = {false, false};
            int resultat;
            resultat = Parking.buscaLlocLliure(-1, 450, placesCodiClient, placesLongitudCm, placesOcupades);
            assertEquals("el codi de soci ha de ser positiu", Parking.ERROR, resultat);

        //resultat = Parking.buscaLlocLliure(0, 99, placesCodiClient, placesLongitudCm, placesOcupades);
            //assertEquals("la mida de la plaça ha de ser >=100", Parking.ERROR, resultat);
            resultat = Parking.buscaLlocLliure(0, -1, placesCodiClient, placesLongitudCm, placesOcupades);
            assertEquals("la mida de la plaça ha de ser >=100", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, null, placesLongitudCm, placesOcupades);
            assertEquals("array codis es null", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, placesCodiClient, null, placesOcupades);
            assertEquals("array longituds es null", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, placesCodiClient, placesLongitudCm, null);
            assertEquals("array places es null", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, new int[]{}, new int[]{}, new boolean[]{});
            assertEquals("parking buit", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, new int[]{0, 0}, new int[]{200}, new boolean[]{true, true});
            assertEquals("arrays de mides diferents", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, new int[]{0, -1}, new int[]{200, 200}, new boolean[]{true, true});
            assertEquals("arrays de socis amb negatius", Parking.ERROR, resultat);

            resultat = Parking.buscaLlocLliure(0, 450, new int[]{0, 0}, new int[]{200, -1}, new boolean[]{true, true});
            assertEquals("arrays de mides amb negatius", Parking.ERROR, resultat);

        }
        //--------------------------------------------------------------

        //-------------------------------------------------------
        //              VALORS VÀLIDS
        //-------------------------------------------------------
        
        
        {
            
            int soci = 33;
            int lon = 300;
            //                             0      1      2     3      4       5    6     7      8      9    10    11
            int[] placesCodiClient   = {    0,    0,     0,    0 ,    75,    75,   75,   75,    33,    33,   33,   33 };
            int[] placesLongitudCm   = {  300,  301,   300,   301,  300,    301,  300,  301 ,  300,   301,  300,  301 };
            boolean[] placesOcupades = { true, true, false, false, false,  false, true, true, true, true, false, false };
            int resultat;
            resultat = Parking.buscaLlocLliure(soci, lon, placesCodiClient, placesLongitudCm, placesOcupades);
            assertEquals(11, resultat);
            assertEquals(true, placesOcupades[11] );
            
            resultat = Parking.buscaLlocLliure(soci, lon, placesCodiClient, placesLongitudCm, placesOcupades);
            assertEquals(3, resultat);
            assertEquals(true, placesOcupades[3] );
            
            resultat = Parking.buscaLlocLliure(soci, lon, placesCodiClient, placesLongitudCm, placesOcupades);
            assertEquals(Parking.NO_HI_HA_LLOC, resultat);            

        }
        
        
        {
            
            int no_soci = 0;
            int lon = 300;
            //                             0      1      2     3      4       5    6     7      8      9    10    11
            int[] placesCodiClient   = {    75,    75,   75,   75,    33,    33,   33,   33 ,   0,    0,     0,    0   };
            int[] placesLongitudCm   = {  300,    301,  300,  301 ,  300,   301,  300,  301  ,300,  301,   300,   301  };
            boolean[] placesOcupades = { false,  false, true, true, true, true, false, false,true, true, false, false   };
            int resultat;
            resultat = Parking.buscaLlocLliure(no_soci, lon, placesCodiClient, placesLongitudCm, placesOcupades);
            assertEquals(11, resultat);
            assertEquals(true, placesOcupades[11] );
            
        }
        
    }

}
