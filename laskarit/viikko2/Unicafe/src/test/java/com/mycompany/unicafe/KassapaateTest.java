
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    // TODO add test methods here.
    
    @Test
    public void luodunPaatteenRahamaaraOikea() {
        int raha = paate.kassassaRahaa();
        
        assertEquals(100000, raha);
    }
    
    @Test
    public void luodunPaatteenLounaatOikein() {
        //voisi tehdä edullisten ja maukkaiden määrälle erilliset testit
        int lounaat = paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty();
        
        assertEquals(0, lounaat);
    }
    
    @Test
    public void edullisenKateisOstoKassaanRahaaJosMaksuRiittava() {
        paate.syoEdullisesti(500);
        int kassanRaha = paate.kassassaRahaa();
        
        assertEquals(100240, kassanRaha);
    }
    
    @Test
    public void edullisenKateisOstoOikeaVaihtorahaJosMaksuRiittava() {
        int vaihtoraha = paate.syoEdullisesti(500);
        
        assertEquals(260, vaihtoraha);
    }
    
    @Test
    public void maukkaanKateisOstoKassaanRahaaJosMaksuRiittava() {
        paate.syoMaukkaasti(500);
        int kassanRaha = paate.kassassaRahaa();
        
        assertEquals(100400, kassanRaha);
    }
    
    @Test
    public void maukkaanKateisOstoOikeaVaihtorahaJosMaksuRiittava() {
        int vaihtoraha = paate.syoMaukkaasti(500);
        
        assertEquals(100, vaihtoraha);
    }
    
    @Test
    public void kateisOstoMyytyjenLounaidenMaaraKasvaaJosMaksuRiittava() {
        //tässä voisi tehdä erikseen testit edullisten ja maukkaiden kohdalla
        paate.syoEdullisesti(500);
        paate.syoEdullisesti(400);
        paate.syoMaukkaasti(500);
        int lounaat = paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty();
        
        assertEquals(3, lounaat);
    }
    
    @Test
    public void edullisenKateisOstoKassaanEiRahaaJosMaksuEiRiita() {
        paate.syoEdullisesti(100);
        int kassanRaha = paate.kassassaRahaa();
        
        assertEquals(100000, kassanRaha);
    }
    
    @Test
    public void edullisenKateisOstoOikeaVaihtorahaJosMaksuEiRiita() {
        int vaihtoraha = paate.syoEdullisesti(100);
        
        assertEquals(100, vaihtoraha);
    }
    
    @Test
    public void maukkaanKateisOstoKassaanEiRahaaJosMaksuEiRiita() {
        paate.syoMaukkaasti(200);
        int raha = paate.kassassaRahaa();
        
        assertEquals(100000, raha);
    }
    
    @Test
    public void maukkaanKateisOstoOikeaVaihtorahaJosMaksuEiRiita() {
        int vaihtoraha = paate.syoMaukkaasti(200);
        
        assertEquals(200, vaihtoraha);
    }
    
    @Test
    public void kateisOstoMyytyjenMaaraEiMuutuMaksuEiRiita() {
        //voisi tehdä edullisille ja maukkaille erikseen
        paate.syoEdullisesti(100);
        paate.syoEdullisesti(200);
        paate.syoMaukkaasti(200);
        
        assertEquals(0, paate.edullisiaLounaitaMyyty()+paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenKorttiostoVeloitusOikeinRahaaOn() {
        paate.syoEdullisesti(kortti);
        
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    public void edullisenKorttiostoVeloitusTrueRahaaOn() {
        boolean arvo = paate.syoEdullisesti(kortti);
        
        assertEquals(true, arvo);
    }
    
    @Test
    public void korttiostoLounaidenMaaraKasvaaRahaaOn() {
        //voisi toteuttaa edullisille ja maukkaille erikseen
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        
        assertEquals(2, paate.edullisiaLounaitaMyyty()+paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanKorttiostoVeloitusOikeinRahaaOn() {
        paate.syoMaukkaasti(kortti);
        
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void maukkaanKorttiostoVeloitusTrueRahaaOn() {
        assertEquals(true, paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void edullisenKorttiostoSaldoEiMuutuRahaaEiOle() {
        kortti.otaRahaa(800);
        paate.syoEdullisesti(kortti);
        
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void edullisenKorttiostoFalseRahaaEiOle() {
        kortti.otaRahaa(800);
        
        assertEquals(false, paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void maukkaanKorttiostoSaldoEiMuutuRahaaEiOle() {
        kortti.otaRahaa(700);
        paate.syoMaukkaasti(kortti);
        
        assertEquals(300, kortti.saldo());
    }
    
    @Test
    public void maukkaanKorttiostoFalseRahaaEiOle() {
        kortti.otaRahaa(700);
        
        assertEquals(false, paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiostoLounaidenMaaraEiKasvaRahaaEiOle() {
        kortti.otaRahaa(800);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        
        assertEquals(0, paate.edullisiaLounaitaMyyty()+paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenKassanRahaEiMuutu() {
        paate.syoEdullisesti(kortti);
        
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void maukkaanKassanRahaEiMuutu() {
        paate.syoMaukkaasti(kortti);
        
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void rahaaLadattaessaKortinSaldoMuuttuu() {
        paate.lataaRahaaKortille(kortti, 100);
        
        assertEquals(1100, kortti.saldo());
    }
    
    @Test
    public void rahaaLadattaessaKassanRahamaaraMuuttuu() {
        paate.lataaRahaaKortille(kortti, 100);
        
        assertEquals(100100, paate.kassassaRahaa());
    }
    
    @Test
    public void negatiivinenSummaLadataanKortinSaldoEiMuutu() {
        paate.lataaRahaaKortille(kortti, -10);
        
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void negatiivinenSummaLadataanKortilleKassaanEiRahaa() {
        paate.lataaRahaaKortille(kortti, -3);
        
        assertEquals(100000, paate.kassassaRahaa());
    }
    
}
