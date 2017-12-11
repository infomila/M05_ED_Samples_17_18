/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171211_aillamentclasses;

/**
 *
 * @author BERNAT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona("Paco", "Pil", "1111111H", "pordios@nolohagas.com");
        EmailManager em = new EmailManager();
        p.enviarEmail("Hola!", "Això és un missatge", em);
    }
    
}
