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
 * @author BERNAT
 */
public class DataTest {

    public DataTest() {
    }

    @Test
    public void testNextDay() throws Exception {

        //---------------------------------------------------------
        {
            int mesos31[] = {1, 3, 5, 7, 8, 10, 12};
            int diesValids[] = {1, 10, 28, 29, 30, 31};
            int diesKO[] = {-1, 0, 32, 40};
            int a = 2000;
            for (int mi = 0; mi < mesos31.length; mi++) {
                int m = mesos31[mi];

                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    try {
                        Data dema = Data.nextDay(new Data(d, m, a));
                        fail("La funció no ha d'acceptar dates errònies!!");
                    } catch (Exception e) {

                    }
                }

                for (int di = 0; di < diesValids.length; di++) {
                    int d = diesValids[di];
                    System.out.println(">>" + (new Data(d, m, a)).toString());
                    Data dema = Data.nextDay(new Data(d, m, a));
                    if (d < 31) {
                        assertEquals(new Data(d + 1, m, a), dema);
                    } else {
                        if (m < 12) {
                            assertEquals(new Data(1, m + 1, a), dema);
                        } else {
                            assertEquals(new Data(1, 1, a + 1), dema);
                        }
                    }
                }
            }
        }
        //---------------------------------------------------------
        {
            int mesos30[] = {4, 6, 9, 11};
            int diesValids[] = {1, 10, 28, 29, 30};
            int diesKO[] = {-1, 0, 31, 40};
            int a = 2000;
            for (int mi = 0; mi < mesos30.length; mi++) {
                int m = mesos30[mi];

                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    try {
                        Data dema = Data.nextDay(new Data(d, m, a));
                        fail("La funció no ha d'acceptar dates errònies!!");
                    } catch (Exception e) {

                    }
                }
                for (int di = 0; di < diesValids.length; di++) {
                    int d = diesValids[di];
                    Data dema = Data.nextDay(new Data(d, m, a));
                    if (d < 30) {
                        assertEquals(new Data(d + 1, m, a), dema);
                    } else {
                        if (m < 12) {
                            assertEquals(new Data(1, m + 1, a), dema);
                        } else {
                            assertEquals(new Data(1, 1, a + 1), dema);
                        }
                    }
                }
            }
        }
        //---------------------------------------------------------
        {
            int m = 2;
            int diesValids[] = {1, 10, 28};
            int diesKO[] = {-1, 0, 29, 30, 31, 40};
            int anys[] = {2001, 2100}; // anys normals
            for (int ai = 0; ai < anys.length; ai++) {
                int a = anys[ai];

                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    try {
                        Data dema = Data.nextDay(new Data(d, m, a));
                        fail("La funció no ha d'acceptar dates errònies!!");
                    } catch (Exception e) {

                    }
                }
                for (int di = 0; di < diesValids.length; di++) {
                    int d = diesValids[di];
                    Data dema = Data.nextDay(new Data(d, m, a));
                    if (d < 28) {
                        assertEquals(new Data(d + 1, m, a), dema);
                    } else {
                        if (m < 12) {
                            assertEquals(new Data(1, m + 1, a), dema);
                        } else {
                            assertEquals(new Data(1, 1, a + 1), dema);
                        }
                    }
                }
            }
        }

        //---------------------------------------------------------
        {
            int m = 2;
            int diesValids[] = {1, 10, 28, 29};
            int diesKO[] = {-1, 0, 30, 31, 40};
            int anys[] = {2004, 2400}; // anys de traspàs
            for (int ai = 0; ai < anys.length; ai++) {
                int a = anys[ai];

                for (int di = 0; di < diesKO.length; di++) {
                    int d = diesKO[di];
                    try {
                        Data dema = Data.nextDay(new Data(d, m, a));
                        fail("La funció no ha d'acceptar dates errònies!!");
                    } catch (Exception e) {

                    }
                }
                for (int di = 0; di < diesValids.length; di++) {
                    int d = diesValids[di];
                    Data dema = Data.nextDay(new Data(d, m, a));
                    if (d < 29) {
                        assertEquals(new Data(d + 1, m, a), dema);
                    } else {
                        if (m < 12) {
                            assertEquals(new Data(1, m + 1, a), dema);
                        } else {
                            assertEquals(new Data(1, 1, a + 1), dema);
                        }
                    }
                }
            }
        }
        //---------------------------------------------------------

        try {
            Data dema = Data.nextDay(new Data(1, 0, 2000));
            fail("La funció no ha d'acceptar mesos  errònis!!");
        } catch (Exception e) {

        }
        try {
            Data dema = Data.nextDay(new Data(1, 0, 2000));
            fail("La funció no ha d'acceptar mesos  errònis!!");
        } catch (Exception e) {

        }
        try {
            Data dema = Data.nextDay(new Data(1, 1, -1));
            fail("La funció no ha d'acceptar anys  errònis!!");
        } catch (Exception e) {

        }
        try {
            Data dema = Data.nextDay(null);
            fail("La funció no ha d'acceptar nuls!!");
        } catch (Exception e) {

        }

    }

}
