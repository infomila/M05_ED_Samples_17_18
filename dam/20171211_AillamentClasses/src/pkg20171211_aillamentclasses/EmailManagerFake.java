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
public class EmailManagerFake implements IEmailManager{

    @Override
    public boolean sendEmail(String email, String subject, String body) {
        System.out.println("Faig veure que envio un correu");
        return true;
    }
    
}
