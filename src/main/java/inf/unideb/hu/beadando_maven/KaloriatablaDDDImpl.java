/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.unideb.hu.beadando_maven;

import inf.unideb.hu.beadando_maven.ConnectionHandler;
import inf.unideb.hu.beadando_maven.Kaja;
import inf.unideb.hu.beadando_maven.Kapcsolo;
import inf.unideb.hu.beadando_maven.Napszak;
import java.lang.Exception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zbocskay
 */
public class KaloriatablaDDDImpl extends ConnectionHandler implements KaloriatablaDDD {
    protected Connection conn = ConnectionHandler.getConnection();
    
    @Override
    public ArrayList<Kaja> getKajak(){
        ArrayList<Kaja> kajalista = new ArrayList<Kaja>();
        String SQLText = "select * from kaja order by NLSSORT(lower(NEV), 'NLS_SORT=west_european')";
        try{

            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(SQLText);
            while (rs.next()) { 
                kajalista.add( new Kaja(rs.getInt("ID"),rs.getString("Nev"),rs.getFloat("Kaloria"), rs.getFloat("Feherje"), rs.getFloat("Szenhidrat")));
            } 

        } catch (SQLException ex) {
            Logger.getLogger(Kaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "kajalista sikeresen létrehozva az összes adatbázisban tárolt kajából");
        return kajalista;
    }
    
    @Override
    public Kaja getKajabyazon(int azon, int x) {
        String SQLText = String.format("select * from kaja where id=%d", azon);
        try{
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(SQLText);
            rs.next();
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "Kaja azonosítása sikeres");
            return new Kaja(rs.getInt("ID"),rs.getString("NEV"), rs.getFloat("KALORIA")*x/100, rs.getFloat("FEHERJE")*x/100, rs.getFloat("SZENHIDRAT")*x/100);
        }catch(SQLException e){
            Logger.getLogger(Kaja.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public Kaja saveKaja(Kaja kaja) {
        String SQLText = String.format("insert into kaja (NEV,KALORIA,FEHERJE,SZENHIDRAT) values (?,?,?,?)");
        PreparedStatement save;
        Statement load;
        if(!this.letezik(kaja)){
                   try{
                        save = conn.prepareStatement(SQLText);
                        save.setString(1, kaja.getNev());
                        save.setFloat(2, kaja.getKaloria());
                        save.setFloat(3, kaja.getFeherje());
                        save.setFloat(4, kaja.getSzenhidrat());
                        save.executeUpdate();
                        String sql = String.format("select id from kaja where rownum <= 1 order by id desc");
                        load = conn.createStatement();
                        ResultSet rs = load.executeQuery(sql);
                        rs.next();
                        kaja.setId(rs.getInt("ID"));
                        Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "A megadott kaja felvéve az adatbázisba új kaja-ként!");
                        return kaja;
                      }catch(SQLException e){
                            Logger.getLogger(Kaja.class.getName()).log(Level.SEVERE, null, e);
                            return null;
                        }
        }else{
            return null;
            
        }        

    }

    @Override
    public Kapcsolo setKajabyDate(Kapcsolo kapcsolo) {
        String SQLText = String.format("insert into kapcsolo (NAPSZAKID,KAJAID,MENNYISEG,DATUM) values (?,?,?,?)");
        PreparedStatement save;
        Statement load;
        try{
            
            save = conn.prepareStatement(SQLText);
            save.setInt(1, kapcsolo.getNapszak().getId());
            save.setInt(2, kapcsolo.getKaja().getId());
            save.setFloat(3, kapcsolo.getMennyiseg());
            save.setString(4, kapcsolo.getDate());
            if(kapcsolo.getMennyiseg() != 0){
            save.executeUpdate();
            String sql = String.format("select id from kapcsolo where rownum <= 1 order by id desc");
                        load = conn.createStatement();
                        ResultSet rs = load.executeQuery(sql);
                        rs.next();
                        kapcsolo.setId(rs.getInt("ID"));
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "kapcsolo sikeresen lementve az adatbázisba");
            return kapcsolo;
            }else
                Logger.getLogger(Kapcsolo.class.getName()).log(Level.WARNING, "kapcsolo mentése sikertelen, nem adott meg mennyiséget!");
                return null;
            
        }catch (SQLException e){
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    }
        
    @Override
    public String getKajabyDate(String date) {
        ArrayList kajak = new ArrayList();
        String SQLText = String.format("select * from kapcsolo where DATUM='%s' order by NAPSZAKID", date);
        try{
            String szoveg;
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(SQLText);
            szoveg = String.format("Kaja név\t\tKalória\tFehérje\tSzénhidrát Napszak Mennyiség Dátum\n");
            
            while(rs.next()){
                    Kaja kaja = getKajabyazon(rs.getInt("KAJAID"), rs.getInt("MENNYISEG"));
                    szoveg += String.format("%-23s %-7s %-7s %-10s %-7s %-9s %-10s %n", kaja.getNev(), kaja.getKaloria(), kaja.getFeherje(), kaja.getSzenhidrat(), getNapszak(rs.getInt("NAPSZAKID")),rs.getInt("MENNYISEG"), date );
         //           szoveg += kaja.getNev()+ "\t\t"+kaja.getKaloria()+"\t"+kaja.getFeherje()+"\t"+kaja.getSzenhidrat()+"\t"+getNapszak(rs.getInt("NAPSZAKID"))+"\t"+rs.getInt("MENNYISEG")+"\t"+date+"\n";
            }
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "kaják sikeresen kilistázva megadott dátum szerint");
            return szoveg;
        }catch(SQLException e){
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.SEVERE, null, e);            
        }
        return null;
    }

    @Override
    public boolean letezik(Kaja kaja) {
        for(Kaja item: getKajak()){
            if(item.equals(kaja))
                Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "azonos nevű kaja már létezik");
                return true;
        }
        Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "Kaja ellenőrzése megtörtént név alapján, a vizsgált érték még nem foglalt");
        return false;
    }

    @Override
    public Napszak getNapszak(int id) {
        String SQLText = String.format("select * from napszak where id=%d", id);
        try{
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(SQLText);
            rs.next();
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.INFO, "napszak azonosítása sikeres");
            return new Napszak(rs.getInt("ID"), rs.getString("NAPSZAK"));
        }catch(SQLException e){
            Logger.getLogger(Napszak.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return null;
    }

    @Override
    public boolean vane(String s) {
        String SQLText = String.format("select DATUM from kapcsolo");
        try{
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(SQLText);

            while(rs.next()){
                if(rs.getString("DATUM").equals(s))
                return true;
            }
        }catch(SQLException e){
            Logger.getLogger(Kapcsolo.class.getName()).log(Level.SEVERE, null, e);
                    return false;
    }return false;
        }
        
      
}
