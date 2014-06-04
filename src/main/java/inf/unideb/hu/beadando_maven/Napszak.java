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
 *
 * @author zbocskay
 */
public class Napszak {

        protected int id;
        protected String napszak;

    public Napszak(int id, String napszak) {
        this.id = id;
        this.napszak = napszak;
    }




    public int getId() {
        return id;
    }

    public String getNapszak() {
        return napszak;
    }

    @Override
    public String toString() {
        return napszak;
    }

    
}
