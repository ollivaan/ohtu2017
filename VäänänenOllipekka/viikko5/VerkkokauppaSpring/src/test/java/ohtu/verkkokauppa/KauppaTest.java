package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class KauppaTest {
    
    Kauppa kauppa;
    
    VarastoInt varasto;
    PankkiInt pankki;
    ViitegeneraattoriInt viitegeneraattori;
    
    @Before
    public void setUp() {
        varasto = mock(Varasto.class);
        pankki = mock(Pankki.class);
        viitegeneraattori = mock(Viitegeneraattori.class);
        
        kauppa = new Kauppa(varasto, pankki, viitegeneraattori);
        
        when(viitegeneraattori.uusi()).thenReturn(42);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));           

        tarkistaTilisiirto("asdman", "00000", 5, 1);
    }
    
    @Test
    public void pankinMetodiaKutsutaanOikeinUseallaEriTuotteella(){
        when(varasto.saldo(0)).thenReturn(3);
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(0)).thenReturn(new Tuote(0, "asd", 1));
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "wasd", 5));
        
        tarkistaTilisiirto("asdman", "00000", 6, 0, 1);
    }
    
    @Test
    public void pankinMetodiaKutsutaanUseallaSamallaTuotteella(){
        when(varasto.saldo(0)).thenReturn(3);
        when(varasto.haeTuote(0)).thenReturn(new Tuote(0, "asderer", 3));
        
        tarkistaTilisiirto("asdman", "00000", 6, 0, 0);
    }
    
    @Test
    public void tilisiirtoaKutsutaanOikeinLoppuneellaJaEiTuotteella(){
        when(varasto.saldo(0)).thenReturn(32);
        when(varasto.saldo(1)).thenReturn(0);
        when(varasto.haeTuote(0)).thenReturn(new Tuote(0, "wasder", 5));
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "asder", 2));
        
        tarkistaTilisiirto("asdman", "00000", 5, 0, 1);
    }
    
    @Test
    public void edellinenToimintoEiNaySeuraavassa(){
        when(varasto.saldo(0)).thenReturn(423);
        when(varasto.saldo(1)).thenReturn(321);
        when(varasto.haeTuote(0)).thenReturn(new Tuote(0, "sdf", 2));
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "wasd", 3));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(0);
        
        tarkistaTilisiirto("asdasd", "00000", 3, 1);
    }
    
    @Test
    public void jokaiselleMaksutapahtumalleUusiViitenumero(){
        when(varasto.saldo(0)).thenReturn(21);
        when(varasto.haeTuote(0)).thenReturn(new Tuote(0, "asdaw", 5));
        
        for(int i = 0 ; i < 3 ; i++){
            kauppaToimii("pekka", "00000", 0);
            verify(viitegeneraattori, times(i+1)).uusi();
        }
    }
    
    @Test
    public void tuotteenPoistaminenToimii(){
        Tuote tuote = new Tuote(0, "asd", 5);
        
        when(varasto.saldo(0)).thenReturn(32);
        when(varasto.haeTuote(0)).thenReturn(tuote);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(0);
        kauppa.poistaKorista(0);
        
        verify(varasto, times(1)).palautaVarastoon(eq(tuote));
    }
    
    private void kauppaToimii(String ostaja, String ostajatilinum, int... tuoteidt){
        kauppa.aloitaAsiointi();
        for(int id : tuoteidt){
            kauppa.lisaaKoriin(id);
        }
        kauppa.tilimaksu(ostaja, ostajatilinum);
    }
    
    private void tarkistaTilisiirto(String ostaja, String ostajatilinum, int summa, int ... tuoteidt){
        kauppaToimii(ostaja, ostajatilinum, tuoteidt);
        
        verify(pankki).tilisiirto(eq(ostaja), eq(42), eq(ostajatilinum), anyString(), eq(summa));
    }
}