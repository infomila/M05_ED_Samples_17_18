package net.iesmila;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BERNAT
 */
public class DemoIText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        crearPdf( "./sortida.pdf", "Hello World!");
    }
    public static void crearPdf( String rutaArxiu, String missatge)
    {
        System.out.println("");
        PdfWriter writer;
        try {
            writer = new PdfWriter(rutaArxiu);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(missatge));
            document.close();            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoIText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
