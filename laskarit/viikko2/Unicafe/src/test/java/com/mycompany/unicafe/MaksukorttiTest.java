package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAsetetaanAlussaOikein() {
        int vastaus = kortti.saldo();
        
        assertEquals(10, vastaus);
    }
    
    @Test
    public void saldonKavattaminenToimiiOikein() {
        kortti.lataaRahaa(5);
        
        assertEquals(15, kortti.saldo());
    }
    
    @Test
    public void saldoVaheneeOikeinRahaaRiittavasti() {
        kortti.otaRahaa(5);
        
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuRahaaEiTarpeeksi() {
        kortti.otaRahaa(13);
        
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahaaOn() {
        boolean arvo = kortti.otaRahaa(5);
        
        assertEquals(true, arvo);
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahaaEiOle() {
        boolean arvo = kortti.otaRahaa(12);
        
        assertEquals(false, arvo);
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
}
