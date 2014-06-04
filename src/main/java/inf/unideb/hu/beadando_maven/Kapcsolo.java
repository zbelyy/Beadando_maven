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
 *
 * @author zbocskay
 */
public class Kapcsolo {
    protected int id;
    protected Kaja kaja;
    protected Napszak napszak;
    protected int mennyiseg;
    protected static String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime()); 

    public Kapcsolo() {
    }
    

    public Kapcsolo(Kaja kaja, Napszak napszak, int mennyiseg) {
        this.kaja = kaja;
        this.napszak = napszak;
        this.mennyiseg = mennyiseg;

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kaja getKaja() {
        return kaja;
    }

    public void setKaja(Kaja kaja) {
        this.kaja = kaja;
    }

    public Napszak getNapszak() {
        return napszak;
    }

    public void setNapszak(Napszak napszak) {
        this.napszak = napszak;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public String getDate() {
        return date;
    }



    @Override
    public String toString() {
        return kaja + "" + napszak + " Mennyiseg= " +mennyiseg+ ", dátum=" + date + "\n";
    }
    
    
}
