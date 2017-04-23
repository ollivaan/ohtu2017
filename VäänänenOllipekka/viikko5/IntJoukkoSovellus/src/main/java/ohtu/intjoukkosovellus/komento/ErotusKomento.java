package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Laskin;


public class ErotusKomento extends LaskinKomento{

    public ErotusKomento(IntJoukko a, IntJoukko b, IntJoukko c, Laskin laskin) {
        super(a, b, c, laskin, "erotus");
    }

    @Override
    protected IntJoukko laske(IntJoukko aj, IntJoukko bj) {
        return laskin.erotus(aj, bj);
    }
}
