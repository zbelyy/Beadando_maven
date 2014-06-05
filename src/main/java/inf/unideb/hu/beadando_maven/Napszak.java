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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a program napszak osztálya, tartalmazza egy nap 3 napszakának elnevezését és azonosítóját.
 * @author zbocskay
 */
public class Napszak {
        /**
         * a napszak azonosítója.
         */
        protected int id;
        /**
         * a napszak neve.
         */
        protected String napszak;

        /**
         * a napszak metódusa.
         * @param id azonosító
         * @param napszak napszak neve
         */
    public Napszak(int id, String napszak) {
        this.id = id;
        this.napszak = napszak;
    }



    /**
     * visszaadja az azonosítót.
     * @return azonosító
     */
    public int getId() {
        return id;
    }
    /**
     * visszaadja a napszakot.
     * @return napszak
     */
    public String getNapszak() {
        return napszak;
    }
    /**
     * kiírja a napszakot a kért formátumban.
     * @return napszak
     */
    @Override
    public String toString() {
        return napszak;
    }

    
}
