/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.unideb.hu.beadando_maven;

import inf.unideb.hu.beadando_maven.Kaja;
import inf.unideb.hu.beadando_maven.Kapcsolo;
import inf.unideb.hu.beadando_maven.Napszak;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * a kalóriatábla interfészünk.
 * @author zbocskay
 */
public interface KaloriatablaDDD {
    
    /**
     * megvizsgálja, hogy létezik e már a kaja.
     * @param kaja megadott kaja
     * @return igaz/hamis érték
     */
    public boolean letezik(Kaja kaja);
    
    /**
     * csekkolja, hogy van e a megadott dátum alatt bejegyzés.
     * @param s a megadott dátum
     * @return igaz/hamis érték
     */
    public boolean vane(String s);
    
    /**
     * visszaadja az összes kaját.
     * @return kajalista az összes kajából
     */
    public ArrayList<Kaja> getKajak();
    
    /**
     * vissza adja a kaját azonosító alapján.
     * @param azon a kaja azonosítója
     * @param x a mennyiség
     * @return visszadja a kaját
     */
    public Kaja getKajabyazon(int azon, int x);
    
    /**
     * felvesz egy új kaját az adatbázisba.
     * @param kaja a megadott kaja
     * @return a kaját amit felvett
     */
    public Kaja saveKaja(Kaja kaja);
    
    /**
     * felvesz egy kaját egy adott dátumra.
     * @param kapcsolo a kapcsoló obejktum
     * @return a kapcsolót
     */
    public Kapcsolo setKajabyDate(Kapcsolo kapcsolo);
    
    /**
     * visszadja az adott nap elfogyasztott kajákat.
     * @param date a megadott dátum
     * @return a kaják a dátum szerint kilistázva
     */
    public String getKajabyDate(String date);
    
    /**
     * visszadja a napszakot id alapján.
     * @param id a napszak azonosítója
     * @return a napszak azonosító alapján
     */
    public Napszak getNapszak(int id);
        
}
