package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Laskin;

public abstract class LaskinKomento extends JoukkoKomento{
    
    protected Laskin laskin;
    private String laskutoimituksenNimi;
    
    public LaskinKomento(IntJoukko a, IntJoukko b, IntJoukko c, Laskin laskin, String laskutoimituksenNimi) {
        super(a, b, c);
        
        this.laskin = laskin;
        this.laskutoimituksenNimi = laskutoimituksenNimi;
    }
    
    @Override
    public boolean toimi(){
        IntJoukko aJoukko = mikaJoukko("1. joukko? ");
        IntJoukko bJoukko = mikaJoukko("2. joukko? ");
        
        System.out.println("A "+laskutoimituksenNimi+" B = " + laske(aJoukko, bJoukko));
        
        return true;
    }
    
    protected abstract IntJoukko laske(IntJoukko aj, IntJoukko bj);
}
