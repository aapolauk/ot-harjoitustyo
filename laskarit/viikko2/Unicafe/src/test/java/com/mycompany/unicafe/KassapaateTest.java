package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti1;
    Maksukortti kortti2;
    
    @Before
    public void setUp() {
        this.kassapaate = new Kassapaate();
        this.kortti1 = new Maksukortti(1000);
        this.kortti2 = new Maksukortti(2);
    }
    
    @Test
    public void rahamaaraOikeaAlussa(){
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullisiaLounaitaAlussa(){
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaitaLounaitaAlussa(){
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahaMuuttuuEdullisessa(){
        kassapaate.syoEdullisesti(300);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahanSuuruusOikeinEdullinen(){
        assertEquals(60, kassapaate.syoEdullisesti(300));
    }
    
    @Test
    public void rahaMuuttuuMaukkaassa(){
        kassapaate.syoMaukkaasti(800);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahanSuuruusOikeinMaukas(){
        assertEquals(400, kassapaate.syoMaukkaasti(800));
    }
    
    @Test
    public void myytyjenLounaidenKasvu1(){
        kassapaate.syoEdullisesti(500);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenLounaidenKasvu2(){
        kassapaate.syoMaukkaasti(800);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenLounaidenKasvu3(){
        kassapaate.syoEdullisesti(20);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenLounaidenKasvu4(){
        kassapaate.syoMaukkaasti(20);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void vaihtorahat1(){
        assertEquals(20, kassapaate.syoEdullisesti(20));
    }
    
    @Test
    public void vaihtorahat2(){
        assertEquals(20, kassapaate.syoMaukkaasti(20));
    }
    
    @Test
    public void maksukortti1(){
        kassapaate.syoEdullisesti(kortti1);
        assertEquals(1000-240, kortti1.saldo());
    }
    
    @Test
    public void maksukortti2(){
        kassapaate.syoMaukkaasti(kortti1);
        assertEquals(600, kortti1.saldo());
    }
    
    @Test
    public void maksukortti3(){
        assertEquals(true, kassapaate.syoEdullisesti(kortti1));
    }
    
    @Test
    public void maksukortti4(){
        assertEquals(true, kassapaate.syoMaukkaasti(kortti1));
    }
    
    @Test
    public void maksukortti5(){
        kassapaate.syoEdullisesti(kortti1);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maksukortti6(){
        kassapaate.syoMaukkaasti(kortti1);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maksukortti7(){
        assertEquals(kassapaate.syoEdullisesti(kortti2), false);
    }
    
    @Test
    public void maksukortti8(){
        assertEquals(kassapaate.syoMaukkaasti(kortti2), false);
    }
    
    @Test
    public void maksukortti9(){
        kassapaate.syoEdullisesti(kortti2);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maksukortti10(){
        kassapaate.syoMaukkaasti(kortti2);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maksukortti11(){
        kassapaate.syoEdullisesti(kortti2);
        assertEquals(2, kortti2.saldo());
    }
    
    @Test
    public void maksukortti12(){
        kassapaate.syoMaukkaasti(kortti2);
        assertEquals(2, kortti2.saldo());
    }
    
    @Test
    public void maksukortti13(){
        kassapaate.syoEdullisesti(kortti1);
        kassapaate.syoMaukkaasti(kortti1);
        kassapaate.syoEdullisesti(kortti2);
        kassapaate.syoMaukkaasti(kortti2);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void lataus1(){
        kassapaate.lataaRahaaKortille(kortti1, 100);
        assertEquals(1100, kortti1.saldo());
    }
    
    @Test
    public void lataus2(){
        kassapaate.lataaRahaaKortille(kortti1, 100);
        assertEquals(100100, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void lataus3(){
        kassapaate.lataaRahaaKortille(kortti1, -100);
        assertEquals(1000, kortti1.saldo());
    }
}

