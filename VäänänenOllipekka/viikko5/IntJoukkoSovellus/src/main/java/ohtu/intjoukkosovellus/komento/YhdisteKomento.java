package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Laskin;

public class YhdisteKomento extends LaskinKomento{

    public YhdisteKomento(IntJoukko a, IntJoukko b, IntJoukko c, Laskin laskin) {
        super(a, b, c, laskin, "yhdiste");
    }

    @Override
    protected IntJoukko laske(IntJoukko aj, IntJoukko bj) {
        return laskin.yhdiste(aj, bj);
    }
    
}
