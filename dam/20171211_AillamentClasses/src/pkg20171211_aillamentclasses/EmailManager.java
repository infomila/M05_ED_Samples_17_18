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
class EmailManager implements IEmailManager{

    @Override
    public boolean sendEmail(String email, String subject, String body) {
        System.out.println("Estic enviant un correu de veritat");
        return true;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
