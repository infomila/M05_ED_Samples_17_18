/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171211_aillamentclasses;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class PersonaTest {
    
    public PersonaTest() {
    }

    @Test
    public void testEnviarEmail() {
        
        Persona p = new Persona("Paco", "Pil", "1111111H", "pordios@nolohagas.com");
        EmailManagerFake em = new EmailManagerFake ();
        boolean resultat = p.enviarEmail("Hola!", "Això és un missatge", em);
        assertEquals(true, resultat);
        
    }

    @Test
    public void testGetNom() {
    }

    @Test
    public void testGetCognom() {
    }

    @Test
    public void testGetNIF() {
    }

    @Test
    public void testGetEmail() {
    }
    
}
