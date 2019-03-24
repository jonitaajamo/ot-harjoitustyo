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
    public void saldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void saldonLisaysOnnistuu() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.05", kortti.toString());
    }
    
    @Test
    public void saldoEiVaheneJosEirahaa() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanOttaminenPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(10));
    }
    
    @Test
    public void rahanOttaminenPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(20));
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
