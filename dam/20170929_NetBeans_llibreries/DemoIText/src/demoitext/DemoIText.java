package demoitext;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * shf ahjsdl fjasdfj asdjf lajsd fkjhs dlfkjh asdkjhfs
 * @author BERNAT
 */
public class DemoIText {

    /**
     * 
     * 
     * asdf
     * asdf
     * 
     * asdf
     * @param args 
     */
     
    public static void main(String[] args) {
        crearPdf("./text.pdf", "Hello World!");
    }
    public static void crearPdf( String pRuta, String pMissatge )
    {
        PdfWriter writer;
        try {
            writer = new PdfWriter(pRuta);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.setBackgroundColor(Color.BLACK);
            Paragraph p = new Paragraph(pMissatge);
            p.setBackgroundColor(Color.PINK);
            document.add(p);
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoIText.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
