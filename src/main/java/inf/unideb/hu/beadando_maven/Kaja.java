/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.unideb.hu.beadando_maven;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Kaja osztály.
 * @author zbocskay
 */
public class Kaja extends ConnectionHandler{
    /**
     * kaja id.
     */
    protected int id;
    /**
     * kaja név.
     */
    protected String Nev;
    /**
     * kaja kalóriatartalma.
     */
    protected float Kaloria;
    /**
     * kaja fehérje tartalma.
     */
    protected float Feherje;
    /**
     * kaja szénhidrát tartalma.
     */
    protected float Szenhidrat;
    /**
     * kaja osztály metódusa.
     * @param id kaja azonosítója
     * @param Nev kaja neve
     * @param Kaloria kaja kalóriája
     * @param Feherje kaja fehérjéje
     * @param Szenhidrat kaja szénhidrátja
     */
    public Kaja(int id, String Nev, float Kaloria, float Feherje, float Szenhidrat) {
        this.id = id;
        this.Nev = Nev;
        this.Kaloria = Kaloria;
        this.Feherje = Feherje;
        this.Szenhidrat = Szenhidrat;
    }
    /**
     * kaja osztály metódusa, azonosítóval paraméterezve.
     * @param id kaja azonosítója
     */
    public Kaja(int id) {
        this.id = id;
    }


    
    /**
     * kaja osztály azonosító nélküli metódusa.
     * @param Nev kaja neve
     * @param Kaloria kaja kalóriatartalma
     * @param Feherje kaja fehérje tartalma
     * @param Szenhidrat kaja szénhidrát tartalma
     */
    public Kaja( String Nev, float Kaloria, float Feherje, float Szenhidrat) {
        this.Nev = Nev;
        this.Kaloria = Kaloria;
        this.Feherje = Feherje;
        this.Szenhidrat = Szenhidrat;
    }
    /**
     * kaja osztály üres metódusa.
     */
    public Kaja() {
    }
    /**
     * megadja a kaja azonosítóját.
     * @return visszadja az azonosítót 
     */
    public int getId() {
        return id;
    }
    /**
     * beállítja a kaja azonosítóját.
     * @param id a kaja azonosítója
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * megadja a kaja nevét.
     * @return visszadja a kaja nevét
     */
    public String getNev() {
        return Nev;
    }
    /**
     * beállítja a kaja nevét.
     * @param Nev megkapja a nevet parméterül
     */
    public void setNev(String Nev) {
        this.Nev = Nev;
    }
    /**
     * megadja a kaja kalóriáját.
     * @return visszaadja a kalóriát
     */
    public float getKaloria() {
        return Kaloria;
    }
    /**
     * beállítja a kaja kalóriáját.
     * @param Kaloria megkapja a kaja kalóriáját
     */
    public void setKaloria(float Kaloria) {
        this.Kaloria = Kaloria;
    }
    /**
     * megadja a kaja fehérjéét.
     * @return visszadja a fehérjét
     */
    public float getFeherje() {
        return Feherje;
    }
    /**
     * beállítja a fehérjét.
     * @param Feherje megkapja a fehérjét
     */
    public void setFeherje(float Feherje) {
        this.Feherje = Feherje;
    }
    /**
     * megadja a szénhidrátot.
     * @return visszaadja a szénhidrátot
     */
    public float getSzenhidrat() {
        return Szenhidrat;
    }
    /**
     * beállítja a szénhidrátot.
     * @param Szenhidrat megkapja a szénhidrátot
     */
    public void setSzenhidrat(float Szenhidrat) {
        this.Szenhidrat = Szenhidrat;
    }
    /**
     * a kaja kiiratásának metódusa.
     * @return kiírja a kaját a kért formátumban.
     */
    @Override
    public String toString() {
        return "Név= " + Nev + ", Kalória=" + Kaloria + ", Fehérje=" + Feherje + ", Szénhidrat=" + Szenhidrat + ", ";
    }
    /**
     * hash code beállító.
     * @return visszaadja a hash-t
     */
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    /**
     * összehasonlítja a kaját név alapján.
     * @param obj objekum amivel összehasonlítjuk a kaját
     * @return igaz/hamis értéket ad vissza, az eredménytől függően
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kaja other = (Kaja) obj;
        if (!Objects.equals(this.Nev, other.Nev)) {
            return false;
        }
        return true;
    }
       
    
}
