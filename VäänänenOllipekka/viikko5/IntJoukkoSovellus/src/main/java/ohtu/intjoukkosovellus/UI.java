package ohtu.intjoukkosovellus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import ohtu.intjoukkosovellus.komento.*;

public class UI {
    
    private final Scanner lukija = new Scanner(System.in);
    private final Laskin laskin = new Laskin();
    
    private Map<String, Komento> komennot;
    
    private IntJoukko a, b, c;
    
    public UI(){
        a = new IntJoukko();
        b = new IntJoukko();
        c = new IntJoukko();
        
        komennot = new HashMap<>();
        
        alustaKaikkiAktivoijat(new LisaysKomento(a, b, c), "lisää", "li");
        alustaKaikkiAktivoijat(new PoistoKomento(a,b,c), "poista", "p");
        alustaKaikkiAktivoijat(new LopetusKomento(), "q", "quit", "lopeta");
        alustaKaikkiAktivoijat(new KuuluukoLukuKomento(a,b,c), "kuuluu", "k");
        alustaKaikkiAktivoijat(new JoukonTulostusKomento(a), "a");
        alustaKaikkiAktivoijat(new JoukonTulostusKomento(b), "b");
        alustaKaikkiAktivoijat(new JoukonTulostusKomento(c), "c");
        alustaKaikkiAktivoijat(new YhdisteKomento(a,b,c,laskin), "yhdiste", "y");
        alustaKaikkiAktivoijat(new LeikkausKomento(a,b,c,laskin), "leikkaus", "le");
        alustaKaikkiAktivoijat(new ErotusKomento(a,b,c,laskin), "erotus", "e");
    }
    
    private void alustaKaikkiAktivoijat(Komento komento, String... aktivoijat){
        for(String aktivoija : aktivoijat){
            komennot.put(aktivoija, komento);
        }
    }

    public void kaynnista() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        
        String luettu;

        while (true) {
            tulostaVaihtoehdot();
            
            luettu = lukija.nextLine().toLowerCase();
            Komento komento = komennot.get(luettu);
            
            if(komento != null){
                if(!komento.toimi()) break;
                continue;
            }else{
                tulostaVirheilmoitus(luettu);
            }
            
            
        }
    }
    
    private void tulostaVirheilmoitus(String luettu){
        System.out.println("Virheellinen komento! " + luettu);
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
    }
    
    private void tulostaVaihtoehdot(){
        System.out.println("\nKäytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }
}
