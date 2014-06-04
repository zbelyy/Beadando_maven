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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zbocskay
 */
public class Kaja extends ConnectionHandler{
    
    protected int id;
    protected String Nev;
    protected float Kaloria;
    protected float Feherje;
    protected float Szenhidrat;

    public Kaja(int id, String Nev, float Kaloria, float Feherje, float Szenhidrat) {
        this.id = id;
        this.Nev = Nev;
        this.Kaloria = Kaloria;
        this.Feherje = Feherje;
        this.Szenhidrat = Szenhidrat;
    }

    public Kaja(int id) {
        this.id = id;
    }


    

    public Kaja( String Nev, float Kaloria, float Feherje, float Szenhidrat) {
        this.Nev = Nev;
        this.Kaloria = Kaloria;
        this.Feherje = Feherje;
        this.Szenhidrat = Szenhidrat;
    }

    public Kaja() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return Nev;
    }

    public void setNev(String Nev) {
        this.Nev = Nev;
    }

    public float getKaloria() {
        return Kaloria;
    }

    public void setKaloria(float Kaloria) {
        this.Kaloria = Kaloria;
    }

    public float getFeherje() {
        return Feherje;
    }

    public void setFeherje(float Feherje) {
        this.Feherje = Feherje;
    }

    public float getSzenhidrat() {
        return Szenhidrat;
    }

    public void setSzenhidrat(float Szenhidrat) {
        this.Szenhidrat = Szenhidrat;
    }

    @Override
    public String toString() {
        return "Név= " + Nev + ", Kalória=" + Kaloria + ", Fehérje=" + Feherje + ", Szénhidrat=" + Szenhidrat + ", ";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

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
