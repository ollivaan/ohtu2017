package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;


public class LisaysKomento extends JoukkoKomento{

    public LisaysKomento(IntJoukko a, IntJoukko b, IntJoukko c) {
        super(a, b, c);
    }

    @Override
    public boolean toimi() {
        IntJoukko joukko = mikaJoukko("Mihin joukkoon? ");
        int lisLuku = luku("\nMikä luku lisätään? ");
        
        joukko.lisaaLuku(lisLuku);
        
        return true;
    }
    
}
