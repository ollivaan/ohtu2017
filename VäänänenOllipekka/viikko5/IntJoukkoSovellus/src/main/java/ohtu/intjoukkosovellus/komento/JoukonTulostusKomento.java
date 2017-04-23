package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;

public class JoukonTulostusKomento implements Komento{
    private final IntJoukko jono;
    
    public JoukonTulostusKomento(IntJoukko joukko){
        jono = joukko;
    }

    @Override
    public boolean toimi() {
        System.out.println(jono);
        return true;
    }
}
