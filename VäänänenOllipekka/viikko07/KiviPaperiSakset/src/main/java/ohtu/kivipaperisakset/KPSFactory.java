package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.tekoaly.HuonompiTekoaly;
import ohtu.kivipaperisakset.tekoaly.ParempiTekoaly;
import ohtu.kivipaperisakset.kali.KPS;
import ohtu.kivipaperisakset.kali.KPSPelaajaVsPelaaja;
import ohtu.kivipaperisakset.kali.KPSTekoaly;

public class KPSFactory {

    public static KPS pelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPS pelaajaVsHelppoAI() {
        return new KPSTekoaly(new HuonompiTekoaly());
    }

    public static KPS pelaajaVsVaikeaAI() {
        return new KPSTekoaly(new ParempiTekoaly(20));
    }
}
