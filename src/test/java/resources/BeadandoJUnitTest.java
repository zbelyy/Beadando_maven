/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import inf.unideb.hu.beadando_maven.ConnectionHandler;
import inf.unideb.hu.beadando_maven.Kaja;
import inf.unideb.hu.beadando_maven.KaloriaSzamlalo;
import inf.unideb.hu.beadando_maven.Kapcsolo;
import inf.unideb.hu.beadando_maven.Napszak;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import inf.unideb.hu.beadando_maven.KaloriatablaDDD;
import inf.unideb.hu.beadando_maven.KaloriatablaDDDImpl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zbocskay
 */
public class BeadandoJUnitTest {
    protected Connection conn = ConnectionHandler.getConnection();
    private static Logger logger = LoggerFactory.getLogger(BeadandoJUnitTest.class);
    public BeadandoJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
     
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String sql = String.format("delete from Kaja where nev='Kaja1'");
        String sql1 = String.format("delete from Kaja where nev='Tökfőzelék'");

        try{
            Statement load = conn.createStatement();
            load.executeQuery(sql);
            load.executeQuery(sql1);
            logger.info("teszt során létrehozott értékek visszaállítása");
        }catch(SQLException e){
            logger.error("a létrehozott értékek visszaállítása sikertelen");
        }
    }
    @Test
    public void GetKajabyAzonTest() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Kaja kaj = new Kaja("Tökfőzelék", 150, 18, 10);
        ddd.saveKaja(kaj);
        
        assertEquals(kaj, ddd.getKajabyazon(kaj.getId(), 100));
        logger.info("a megadott kaja tárolva és azonosító szerint visszakeresve az adatbázisból");
    }
    
    @Test
    public void setKajabyDateTest() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Kapcsolo kapcs = new Kapcsolo(ddd.getKajabyazon(1, 100), ddd.getNapszak(1), 0);
        ddd.setKajabyDate(kapcs);
        String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
        assertEquals(date, kapcs.getDate());
        assertEquals(0, kapcs.getId());
        logger.info("kapcsolo létrehozása aktuális dátummal sikeresen megtörtént, ill. adatbázis mentés nulla súlyérték eseten sikertelen");
    }
     @Test
    public void getKajabyDateTest() throws ClassNotFoundException{
        String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Kapcsolo kapcs = new Kapcsolo(ddd.getKajabyazon(1, 100), ddd.getNapszak(1), 300);
        ddd.setKajabyDate(kapcs);
        
        assertEquals(true, ddd.getKajabyDate(date).contains(kapcs.getKaja().getNev()));
        logger.info("az aktuális dátummal létrehozott kapcsolo megtalálató az aktuális dátum alatt az adatbázis táblában!");
    }
    
    @Test
    public void letezikKajaTest() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Kaja kaj = ddd.getKajabyazon(1, 100);
        assertEquals(true, ddd.letezik(kaj));
        logger.error("a vizsgált kaja létezik az adatbáziban");
    }
       @Test
    public void getNapszakTest() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Napszak nap = new Napszak(3, "ESTE");
        
           assertEquals(nap.getNapszak(), ddd.getNapszak(3).getNapszak());
    }
       @Test
    public void vane() throws ClassNotFoundException{
        String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
           assertEquals(true, ddd.vane(date));
           assertEquals(true, ddd.vane("2014.06.01"));
           assertEquals(false, ddd.vane("2014.05.29"));
    }
    
    @Test
    public void GetKajaTest() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        ArrayList<Kaja> kajaList = ddd.getKajak();
        assertEquals(kajaList, ddd.getKajak());
    }
    
    @Test
    public void SaveKajaTest() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Kaja kaja1 = new Kaja("Kaja1",100,100,100);
        ddd.saveKaja(kaja1);
        ArrayList<Kaja> kajaList = ddd.getKajak();
        assertEquals(true, kajaList.contains(kaja1));
    }

    
    @Test
    public void SaveKajaTestKetszer() throws ClassNotFoundException{
        KaloriatablaDDD ddd = new KaloriatablaDDDImpl();
        Kaja kaja1 = new Kaja("Kaja1",100,100,100);
        assertEquals(kaja1, ddd.saveKaja(kaja1));
        assertEquals(null, ddd.saveKaja(kaja1));
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
