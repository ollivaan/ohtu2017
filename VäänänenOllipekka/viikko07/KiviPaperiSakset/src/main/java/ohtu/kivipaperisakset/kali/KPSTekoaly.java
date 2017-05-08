package ohtu.kivipaperisakset.kali;

import ohtu.kivipaperisakset.tekoaly.Tekoaly;

public class KPSTekoaly extends KPS{

    private final Tekoaly tekoaly;
    
    public KPSTekoaly(Tekoaly tekoaly){
        this.tekoaly = tekoaly;
    }

    @Override
    public String toinenPelaajaToimii(String ekanSiirto) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        
        tekoaly.tallennaVastustajanSiirto(ekanSiirto);
        
        return siirto;
    }
}