package ohtu.kivipaperisakset.kali;

public class KPSPelaajaVsPelaaja extends KPS{

    @Override
    public String toinenPelaajaToimii(String ekanSiirto) {
        System.out.println("Toisen pelaajan siirto: ");
        return lukija.nextLine();
    }
}