package ohtu.intjoukkosovellus.komento;

import java.util.Scanner;
import ohtu.intjoukkosovellus.IntJoukko;

public abstract class JoukkoKomento implements Komento{
    
    protected IntJoukko a, b, c;
    protected Scanner lukija = new Scanner(System.in);

    public JoukkoKomento(IntJoukko a, IntJoukko b, IntJoukko c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    protected String rivi(){
        return lukija.nextLine().toLowerCase();
    }
    
    protected int luku(String prompt){
        System.out.println(prompt);
        return lukija.nextInt();
    }
    
    protected IntJoukko mikaJoukko(String prompt) {
        System.out.println(prompt);
        
        String luettu = rivi();
        while (true) {
            switch (luettu) {
                case "a":
                    return a;
                case "b":
                    return b;
                case "c":
                    return c;
                default:
                    System.out.println("Virheellinen joukko! " + luettu);
                    System.out.print("Yritä uudelleen!");
                    luettu = rivi();
            }
        }
    }
}
