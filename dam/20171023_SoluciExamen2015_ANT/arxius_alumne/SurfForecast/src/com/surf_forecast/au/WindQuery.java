package com.surf_forecast.au;

import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Utilitza la pàgina web http://es.surf-forecast.com/
 * per consultar la força del vent a una platja de les
 * que es disposa informació. Cal proporcionar un 
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
     * Funció que consulta a la pàgina web de la platja i 
     * n'extreu la velocitat actual del vent. 
     * NOTES: 
     *         - aquesta funció requereix connexió a Internet
     *         - està programada usant l'utilíssima API JSoup.
     * 
     * @param codiPlatja és el codi de la platja de la que busquem el vent
     * @return la velocitat del vent en kilòmetres per hora
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
