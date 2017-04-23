package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;

public class PoistoKomento extends JoukkoKomento{

    public PoistoKomento(IntJoukko a, IntJoukko b, IntJoukko c) {
        super(a, b, c);
    }

    @Override
    public boolean toimi() {
        IntJoukko joukko = mikaJoukko("Mistä joukosta? ");
        int lisLuku = luku("Mikä luku poistetaan? ");
        
        joukko.poistaLuku(lisLuku);
        
        return true;
    }
    
}
