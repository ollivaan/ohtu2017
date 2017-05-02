
package ohtu;

import javax.swing.JTextField;


class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
    this.sovellus=sovellus;
    this.syotekentta=syotekentta;
    this.tuloskentta=tuloskentta;
    }

    @Override
    public void suorita() {
        sovellus.edellinen(sovellus.tulos());
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("");
        
    }

    @Override
    public void peru() {
       syotekentta.setText("");
       tuloskentta.setText("" + sovellus.getEdellinen());
    }
    
}
