/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thenextday;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuari
 */
public class DataTest {

    public DataTest() {
    }

    @Test
    public void testNextDay() throws Exception{

        {
            // Mesos de 31 dies 
            int mesos31[] = {1, 3, 5, 7, 8, 10, 12};
            int diesOk[] = {1, 5, 30, 31};
            int diesKO[] = {-1, 0, 32, 40};
            int any = 2000;
            for (int mi = 0; mi < mesos31.length; mi++) {
                int m = mesos31[mi];
            /*
               for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    Data unaData = new Data(d, m, any);
                    try {
                        Data tomorrow = Data.nextDay(unaData);
                        fail("No podem acceptar dates errònies:" + unaData);
                    } catch (Exception ex) {

                    }
                }*/

                for (int di = 0; di < diesOk.length; di++) {
                    int d = diesOk[di];
                    Data unaData = new Data(d, m, any);
                    System.out.println(">"+unaData);
                    Data tomorrow = Data.nextDay(unaData);
                    if (d < 31) {
                        assertEquals(new Data(d + 1, m, any), tomorrow);
                    } else if (m < 12) {
                        assertEquals("Data errònia: original" + unaData + ", obtingut:" + tomorrow, new Data(1, m + 1, any), tomorrow);
                    } else {
                        assertEquals(new Data(1, 1, any + 1), tomorrow);
                    }
                }
            }
        }
        //-----------------------------------------------------------------------
        {

            // Mesos de 30 dies 
            int mesos30[] = {4, 6, 9, 11};
            int diesOk[] = {1, 5, 30};
            int diesKO[] = {-1, 0, 31, 40};
            int any = 2000;
            for (int mi = 0; mi < mesos30.length; mi++) {
                int m = mesos30[mi];
/*
                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    Data unaData = new Data(d, m, any);
                    try {
                        Data tomorrow = Data.nextDay(unaData);
                        fail("No podem acceptar dates errònies:" + unaData);
                    } catch (Exception ex) {

                    }
                }*/

                for (int di = 0; di < diesOk.length; di++) {
                    int d = diesOk[di];
                    Data unaData = new Data(d, m, any);
                    //System.out.print(">"+unaData);
                    Data tomorrow = Data.nextDay(unaData);
                    if (d < 30) {
                        assertEquals(new Data(d + 1, m, any), tomorrow);
                    } else if (m < 12) {
                        assertEquals("Data errònia: original" + unaData + ", obtingut:" + tomorrow, new Data(1, m + 1, any), tomorrow);
                    } else {
                        assertEquals(new Data(1, 1, any + 1), tomorrow);
                    }
                }
            }
        }
        //-----------------------------------------------------------------------
        {

            // FEBRER (any normal )!!!!!!
            int m = 2;
            int diesOk[] = {1, 5, 28};
            int diesKO[] = {-1, 0, 29, 40};
            int anys[] = { 2001, 2100} ;
            for (int ai = 0; ai < anys.length; ai++) {
                int any = anys[ai];
/*
                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    Data unaData = new Data(d, m, any);
                    try {
                        Data tomorrow = Data.nextDay(unaData);
                        fail("No podem acceptar dates errònies:" + unaData);
                    } catch (Exception ex) {

                    }
                }*/

                for (int di = 0; di < diesOk.length; di++) {
                    int d = diesOk[di];
                    Data unaData = new Data(d, m, any);
                    System.out.println(">"+unaData);
                    Data tomorrow = Data.nextDay(unaData);
                    if (d < 28) {
                        assertEquals(new Data(d + 1, m, any), tomorrow);
                    } else if (m < 12) {
                        assertEquals("Data errònia: original" + unaData + ", obtingut:" + tomorrow, new Data(1, m + 1, any), tomorrow);
                    } else {
                        assertEquals(new Data(1, 1, any + 1), tomorrow);
                    }
                }
            }
        }
        //-----------------------------------------------------------------------
        {

            // FEBRER (any traspas )!!!!!!
            int m = 2;
            int diesOk[] = {1, 5, 29};
            int diesKO[] = {-1, 0, 30, 40};
            int anys[] = { 2004, 2400} ;
            for (int ai = 0; ai < anys.length; ai++) {
                int any = anys[ai];
/*
                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    Data unaData = new Data(d, m, any);
                    try {
                        Data tomorrow = Data.nextDay(unaData);
                        fail("No podem acceptar dates errònies:" + unaData);
                    } catch (Exception ex) {

                    }
                }*/

                for (int di = 0; di < diesOk.length; di++) {
                    int d = diesOk[di];
                    Data unaData = new Data(d, m, any);
                    System.out.println(">"+unaData);
                    Data tomorrow = Data.nextDay(unaData);
                    if (d < 29) {
                        assertEquals(new Data(d + 1, m, any), tomorrow);
                    } else if (m < 12) {
                        assertEquals("Data errònia: original" + unaData + ", obtingut:" + tomorrow, new Data(1, m + 1, any), tomorrow);
                    } else {
                        assertEquals(new Data(1, 1, any + 1), tomorrow);
                    }
                }
            }
        }
        
        //-----------------------------------------------------------------------
        
        {
            Data unaData = new Data(2, 0, 2000);
            try {
                Data tomorrow = Data.nextDay(unaData);
                fail("No podem acceptar mesos errònis:" + unaData);
            } catch (Exception ex) {

            }
        }
        {
            Data unaData = new Data(2, 13, 2000);
            try {
                Data tomorrow = Data.nextDay(unaData);
                fail("No podem acceptar mesos errònis:" + unaData);
            } catch (Exception ex) {

            }
        }
        {
            Data unaData = new Data(2, 2, -1);
            try {
                Data tomorrow = Data.nextDay(unaData);
                fail("No podem acceptar anys errònis:" + unaData);
            } catch (Exception ex) {

            }
        }
        {             
            try {
                Data tomorrow = Data.nextDay(null); 
                fail("No podem acceptar nulls" );
            } catch (Exception ex) {

            }
        }
        
    }

}
