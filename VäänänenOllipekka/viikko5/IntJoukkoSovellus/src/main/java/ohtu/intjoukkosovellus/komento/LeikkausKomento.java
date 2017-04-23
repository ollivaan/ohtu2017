package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Laskin;

public class LeikkausKomento extends LaskinKomento{

    public LeikkausKomento(IntJoukko a, IntJoukko b, IntJoukko c, Laskin laskin) {
        super(a, b, c, laskin, "leikkaus");
    }

    @Override
    protected IntJoukko laske(IntJoukko aj, IntJoukko bj) {
        return laskin.leikkaus(aj, bj);
    }
    
}
