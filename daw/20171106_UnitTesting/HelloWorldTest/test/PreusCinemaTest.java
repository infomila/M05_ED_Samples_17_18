/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class PreusCinemaTest {
    
    public PreusCinemaTest() {
    }

    @Test
    public void testGetPreu() {
        {
            int testos[][] = {{1,25},{2,25},{3,25},{4,25},{5,25},{6,25},{7,25},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{7,8},{1,18},{1,17},{1,19},{1,4},{1,149}};
            int sortides[] = { 5,5,4,5,5,6,6,4,4,3,4,4,5,5,5,4,5,4,5};
            PreusCinema pc = new PreusCinema();
            double p;
            for(int i=0;i<testos.length;i++) {
                p = pc.getPreu(testos[i][1], testos[i][0], false);//  <----- SENSE CARNET !!!
                assertEquals(sortides[i], p, 0.0001);
            }
        }
          // testos amb carnet
        {
            int testos[][] = {{1,20},{3,20},{6,20},{1,7},{3,7},{6,7}};
            int sortides[] = { 4,4,6,3,3,5};
            PreusCinema pc = new PreusCinema();
            double p;
            for(int i=0;i<testos.length;i++) {
                p = pc.getPreu(testos[i][1], testos[i][0], true);//  <----- AMB CARNET !!!
                System.out.println("edat:"+testos[i][1]+", dia:"+ testos[i][0]);
                assertEquals(sortides[i], p, 0.0001);
            } 
        }
        
        PreusCinema pc = new PreusCinema();
        int testos[][] = {{1,3},{1,150},{1,0},{1,-2},
                          {0,25},{8,25},{-1,25},{0,0}};
        
        for(int i=0;i<testos.length;i++) {
            try {
                double p = pc.getPreu(testos[i][1], testos[i][0], true);
                fail("Validació de dia de la setmana i edat errònies");
            } catch(Exception ex) {

            }
        }
        
        
    }
    
    
}
