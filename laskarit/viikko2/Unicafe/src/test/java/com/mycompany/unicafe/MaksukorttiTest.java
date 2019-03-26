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
    public void OikeaMaaraRahaaAlussa(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void LataaminenKasvattaaOikein(){
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20",kortti.toString());
    }
    
    @Test
    public void VaheneeKunvahenee(){
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void eiVaheneKunEiVahene(){
        kortti.otaRahaa(15);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void metodiToimiiKunTarpeeksiRahaa(){
        assertEquals(kortti.otaRahaa(5), true);
    }
    
    @Test
    public void metodiToimiiKunEiTarpeeksiRahaa(){
        assertEquals(kortti.otaRahaa(15), false);
    }
    
    
}
