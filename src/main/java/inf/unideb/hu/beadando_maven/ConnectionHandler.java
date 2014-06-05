/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.unideb.hu.beadando_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Megvalósítja az adatbázissal való kommunikálást.
 * @author zbocskay
 */
public class ConnectionHandler {
    /**
     * Statikus Connection adattag.
     */
    private static Connection conn;
    /**
     * a felhasználónév beállítása.
     */
    private static String userName = "H_IRD0M4";
    /**
     * jelszó megadása.
     */
    private static String password = "kassai";
    /**
     * adatbázis elérése.
     */
    private static final String ORACLE_DB = "jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g";
    
    /**
     * üres metódus definiálása.
     */
    public ConnectionHandler() {
    }
    /**
     * kapcsolat felépítése az adatbázissal.
     * @return kapcsolat létrehozva
     */
    public static Connection getConnection(){
        if(conn == null){
            try{
                Class.forName("oracle.jdbc.OracleDriver").newInstance();
            }catch(InstantiationException e1){
                e1.printStackTrace();
            }catch(IllegalAccessException e1){
                e1.printStackTrace();
            }catch(ClassNotFoundException e1){
                e1.printStackTrace();
            }
            try{
                conn = DriverManager.getConnection(ORACLE_DB, userName, password);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }
    /**
     * bezárja a kapcsolatot az adatbázissal.
     */
    public static void closeConnection(){
        if ( conn != null ){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
