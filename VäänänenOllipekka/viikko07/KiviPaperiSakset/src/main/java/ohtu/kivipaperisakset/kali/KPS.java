package ohtu.kivipaperisakset.kali;

import java.util.Scanner;
import ohtu.kivipaperisakset.Tuomari;

public abstract class KPS {
    
    protected final Scanner lukija;
    private final Tuomari tuomari;

    public KPS() {
        this.lukija = new Scanner(System.in);
        this.tuomari = new Tuomari();
    }
    
    public void pelaa(){
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        
        String ekanSiirto = ensimmaisenPelaajaToimii();
        String tokanSiirto = toinenPelaajaToimii(ekanSiirto);
        
        while(laillisetSiirrot(ekanSiirto, tokanSiirto)){
            
            System.out.println("");
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            
            ekanSiirto = ensimmaisenPelaajaToimii();
            tokanSiirto = toinenPelaajaToimii(ekanSiirto);
            
        }

        System.out.println("\nKiitos!");
        System.out.println(tuomari);
    }
    
    public String ensimmaisenPelaajaToimii(){
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return lukija.nextLine();
    }
    public abstract String toinenPelaajaToimii(String ekanSiirto);
    
    private boolean laillisetSiirrot(String siirto1, String siirto2){
        return laillinenSiirto(siirto1) && laillinenSiirto(siirto2);
    }
    
    private boolean laillinenSiirto(String siirto){
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
}
