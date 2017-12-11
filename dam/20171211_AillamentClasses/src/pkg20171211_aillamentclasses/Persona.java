
package pkg20171211_aillamentclasses;

/**
 *
 * @author BERNAT
 */
public class Persona {

    public boolean enviarEmail(String subject, String body, 
            IEmailManager em) {
        return em.sendEmail( email, subject, body);
    }
    
    
    private String nom , cognom, NIF, email;

    public Persona(String nom, String cognom, String NIF, String email) {
        this.nom = nom;
        this.cognom = cognom;
        this.NIF = NIF;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getNIF() {
        return NIF;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
