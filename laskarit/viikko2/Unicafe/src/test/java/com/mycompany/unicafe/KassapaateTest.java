/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonitaajamo
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
   
    //kassan toiminta
    @Test
    public void kassassaRahaaOikeinAlussa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void alussaEdullisiaLounaitaMyytyNolla() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void alussaMaukkaitaLounaitaMyytyNolla() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    //edulliset käteisostot
    @Test
    public void edullisenLounaanOstonJalkeenVaihtoRahaOikein() {
        assertEquals(10, kassa.syoEdullisesti(250));
    }
    
    @Test
    public void edullisenLounaanOstonJalkeenKassaOikein() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullisetLounaatKasvaa() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisestiSyotaessaRahatPalautetaanJosEiTarpeeksi() {
        assertEquals(200, kassa.syoEdullisesti(200));
    }
    
    @Test
    public void edullisestiSyotaessaMyydytLounaatOikeinJosEiTarpeeksi() {
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisestiSyotaessaKassaOikeinJosEiTarpeeksi() {
        kassa.syoEdullisesti(10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    //maukkaat käteisostot
    @Test
    public void maukkaanLounaanOstonJalkeenVaihtoRahaOikein() {
        assertEquals(10, kassa.syoMaukkaasti(410));
    }
    
    @Test
    public void maukkaanLounaanOstonJalkeenKassaOikein() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaatLounaatKasvaa() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    
    @Test
    public void maukkaastiSyotaessaRahatPalautetaanJosEiTarpeeksi() {
        assertEquals(200, kassa.syoMaukkaasti(200));
    }
    
    @Test
    public void maukkastiSyotaessaMyydytLounaatOikeinJosEiTarpeeksi() {
        kassa.syoMaukkaasti(10);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkastiSyotaessaKassaOikeinJosEiTarpeeksi() {
        kassa.syoMaukkaasti(10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    //edulliset korttiostot
    @Test
    public void edullisestiSyotaessaOstoOnnistuu() {
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void edullisestiSyotaessaMyynnitKasvaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisestiSyotaessaKortinSummaEiMuutuJosEiTarpeeksiVaroja() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(40, kortti.saldo());
    }
    
    @Test
    public void edullisestiSyotaessaMyytyjenMaaraEiKasvaJosEiTarpeeksiVaroja() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(4, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisestiSyotaessaPalautetaanFalseJosEiTarpeeksiVaroja() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void edullisestiSyotaessaKortillaKassanSummaEiMuutu() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaastiSyotaessaOstoOnnistuu() {
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void maukkastiSyotaessaMyynnitKasvaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaastiSyotaessaKortinSummaEiMuutuJosEiTarpeeksiVaroja() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void maukkaastiSyotaessaMyytyjenMaaraEiKasvaJosEiTarpeeksiVaroja() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaastiSyotaessaPalautetaanFalseJosEiTarpeeksiVaroja() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void maukkaastiSyotaessaKortillaKassanSummaEiMuutu() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    //kortin lataaminen
    @Test
    public void korttiaLadattaessaSummaLisataanKassaan() {
        kassa.lataaRahaaKortille(kortti, 10);
        assertEquals(100010, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiaLadattaessaNegatiivisenSummanLatausEiOnnistu() {
        kassa.lataaRahaaKortille(kortti, -10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
}
