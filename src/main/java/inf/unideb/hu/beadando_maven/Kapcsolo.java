/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.unideb.hu.beadando_maven;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * ez az osztály tartalmazza a naplózáshoz szükséges adatokat.
 * @author zbocskay
 */
public class Kapcsolo {
    /**
     * a kapcoslo azonosítója.
     */
    protected int id;
    /**
     * a kaja objektum.
     */
    protected Kaja kaja;
    /**
     * a napszak objektum.
     */
    protected Napszak napszak;
    /**
     * a mennyiség adattag.
     */
    protected int mennyiseg;
    /**
     * a dátum adattag ami mindig a használatának az aktuális napját kapja meg értékül.
     */
    protected static String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime()); 
    /**
     * az osztály alapértelmezett metódusa.
     */
    public Kapcsolo() {
    }
    
    /**
     * az osztály metódusa, azonosító nélkül.
     * @param kaja a kaja objektum
     * @param napszak a napszak objektum
     * @param mennyiseg a mennyiség adattag
     */
    public Kapcsolo(Kaja kaja, Napszak napszak, int mennyiseg) {
        this.kaja = kaja;
        this.napszak = napszak;
        this.mennyiseg = mennyiseg;

    }
    /**
     * visszaadja az azonosítót.
     * @return azonosító
     */
    public int getId() {
        return id;
    }
    
    /**
     * beállítja az azonosítót.
     * @param id azonosító
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * visszaadja a kaját.
     * @return a kaja
     */
    public Kaja getKaja() {
        return kaja;
    }
    /**
     * beállítja a kaját.
     * @param kaja a megadott kaja
     */
    public void setKaja(Kaja kaja) {
        this.kaja = kaja;
    }
    /**
     * visszaadja a napszakot.
     * @return a napszak
     */
    public Napszak getNapszak() {
        return napszak;
    }
    /**
     * beállítja a napszakot.
     * @param napszak a megadott napszak
     */
    public void setNapszak(Napszak napszak) {
        this.napszak = napszak;
    }
    /**
     * visszaadja a mennyiséget.
     * @return a mennyiség
     */
    public int getMennyiseg() {
        return mennyiseg;
    }
    /**
     * beállítja a mennyiséget.
     * @param mennyiseg a megadott mennyiség
     */
    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }
    /**
     * visszaadja a dátumot.
     * @return a dátum
     */
    public String getDate() {
        return date;
    }


    /**
     * kiírja a kapcsoló objektumot a megadott formátum alapján.
     * @return a kívánt szöveg
     */
    @Override
    public String toString() {
        return kaja + "" + napszak + " Mennyiseg= " +mennyiseg+ ", dátum=" + date + "\n";
    }
    
    
}
