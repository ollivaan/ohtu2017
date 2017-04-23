
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            kapasiteetti = OLETUSKAPASITEETTI;
        }
        if (kasvatuskoko <= 0) {
            kasvatuskoko = OLETUSKASVATUS;
        }
        
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaLuku(int luku) {

        if (!onkoJoukossa(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;

            if (alkioidenLkm == ljono.length) {
                kasvataTaulukkoa();
            }
            return true;
        }
        
        return false;
    }

    public boolean onkoJoukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        
        return false;
    }

    public boolean poistaLuku(int luku) {
        int kohta = luvunSijainti(luku);
        if (kohta == -1) {
            return false;
        }
        
        poistaLukuKohdasta(kohta);
        
        return true;
    }
    
    private void kasvataTaulukkoa(){
        int[] uusiTaulukko = new int[ljono.length + kasvatuskoko];
        kopioiTaulukko(ljono, uusiTaulukko);
        ljono = uusiTaulukko;
    }
    
    private void poistaLukuKohdasta(int kohta){
        ljono[kohta] = 0;
        
        for (int j = kohta+1; j < alkioidenLkm; j++) {
            ljono[j-1] = ljono[j];
        }
        
        alkioidenLkm--;
    }
    
    private int luvunSijainti(int luku){
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
            }
        }
        
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        switch (alkioidenLkm) {
            case 0:
                return "{}";
            case 1:
                return "{" + ljono[0] + "}";
            default:
                String tuotos = "{";
                for (int i = 0; i < alkioidenLkm - 1; i++) {
                    tuotos += ljono[i];
                    tuotos += ", ";
                }
                tuotos += ljono[alkioidenLkm - 1];
                tuotos += "}";
                return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        
        return taulu;
    }
        
}