package com.surf_forecast.au;

import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Utilitza la p�gina web http://es.surf-forecast.com/
 * per consultar la for�a del vent a una platja de les
 * que es disposa informaci�. Cal proporcionar un 
 * codi de platja conegut per la web.
 * 
 * @author BERNAT
 */
public class WindQuery implements Callable<Integer>{
    private String mCodiPlatja;

    public WindQuery(String codiPlatja) {
        this.mCodiPlatja = codiPlatja;
    }
    
    @Override
    public Integer call() throws Exception {
        return WindQuery.forcaVent(this.mCodiPlatja);
    }
    
    /**
     * Funci� que consulta a la p�gina web de la platja i 
     * n'extreu la velocitat actual del vent. 
     * NOTES: 
     *         - aquesta funci� requereix connexi� a Internet
     *         - est� programada usant l'util�ssima API JSoup.
     * 
     * @param codiPlatja �s el codi de la platja de la que busquem el vent
     * @return la velocitat del vent en kil�metres per hora
     */
    public static int forcaVent(String codiPlatja) {
        try {

            Document doc = Jsoup.connect("http://es.surf-forecast.com/breaks/" + codiPlatja + "/forecasts/feed/m").get();
            String title = doc.toString();

            Elements e = doc.select("#table-current .windcell span");

            return Integer.parseInt(e.text());

        } catch (Exception e) {
            //e.printStackTrace();
            return -1;
        }
    }

    public String getCodiPlatja() {
        return mCodiPlatja;
    }

}
