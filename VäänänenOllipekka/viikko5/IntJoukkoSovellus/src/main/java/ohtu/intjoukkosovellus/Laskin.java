package ohtu.intjoukkosovellus;

public class Laskin {
    
    private IntJoukko tulos;
    private int[] aTaulu;
    private int[] bTaulu;
    
    public IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        alusta(a, b);
        
        for (int i = 0; i < aTaulu.length; i++) {
            tulos.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            tulos.lisaaLuku(bTaulu[i]);
        }
        
        return tulos;
    }

    public IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        alusta(a, b);
        
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    tulos.lisaaLuku(bTaulu[j]);
                    break;
                }
            }
        }
        return tulos;

    }
    
    public IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        alusta(a, b);
        
        for (int i = 0; i < aTaulu.length; i++) {
            tulos.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            tulos.poistaLuku(i);
        }
 
        return tulos;
    }
    
    private void alusta(IntJoukko a, IntJoukko b){
        tulos = new IntJoukko();
        aTaulu = a.toIntArray();
        bTaulu = b.toIntArray();
    }
}
