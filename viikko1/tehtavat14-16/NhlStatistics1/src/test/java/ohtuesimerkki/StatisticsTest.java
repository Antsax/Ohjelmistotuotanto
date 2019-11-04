/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void etsiPelaaja() {
        Player pelaaja = stats.search("Semenko");
        assertTrue(pelaaja.getName().equals("Semenko"));
    }
    
    @Test
    public void pelaajaEiOle() {
        Player pelaaja = stats.search("Testi");
        assertNull(pelaaja);
    }
    
    @Test
    public void oikeaMaaraPelaajiaTiimissa() {
        List<Player> tiimi = stats.team("EDM");
        assertTrue(tiimi.size() == 3);
    }
    
    @Test
    public void parhaimmatPelaajat() {
        List<Player> parhaat = stats.topScorers(1);
        assertNotNull(parhaat);
    }
}