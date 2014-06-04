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
 *
 * @author zbocskay
 */
public class ConnectionHandler {
    private static Connection conn;
    
    private static String userName = "H_IRD0M4";
    private static String password = "kassai";
    
    private static final String ORACLE_DB = "jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g";

    public ConnectionHandler() {
    }
    
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
