package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;

public class KuuluukoLukuKomento extends JoukkoKomento{

    public KuuluukoLukuKomento(IntJoukko a, IntJoukko b, IntJoukko c) {
        super(a, b, c);
    }

    @Override
    public boolean toimi() {
        IntJoukko joukko = mikaJoukko("Mihin joukkoon? ");
        int kysLuku = luku("Mikä luku? ");
        
        if (joukko.onkoJoukossa(kysLuku)) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
        
        return true;
    }
    
}
