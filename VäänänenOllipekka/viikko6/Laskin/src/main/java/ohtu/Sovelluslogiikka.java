package ohtu;

public class Sovelluslogiikka {
 
    private int tulos;
    private int edellinen;
 
    public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
    public void edellinen(int edellinen) {        
        this.edellinen=edellinen;             
        
    }
    public int getEdellinen(){
        return edellinen;
    }
}