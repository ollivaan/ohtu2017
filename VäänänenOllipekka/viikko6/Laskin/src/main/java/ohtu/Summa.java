/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author ollivaan
 */
class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
    this.sovellus=sovellus;
    this.syotekentta=syotekentta;
    this.tuloskentta=tuloskentta;
    
    
         
    }

    @Override
    public void suorita() {
        sovellus.edellinen(sovellus.tulos());      
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());

    }

    @Override
    public void peru() {
       syotekentta.setText("");
       tuloskentta.setText("" + sovellus.getEdellinen());
//       sovellus.getEdellinen();       
    }
    
}
