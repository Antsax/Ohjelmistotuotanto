package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Ostoskori {

    ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

    public void lisaa(Tuote t) {
        tuotteet.add(t);
    }

    public void poista(Tuote t) {
        tuotteet.remove(t);
    }

    public int hinta() {
        int hinta = 0;

        for (Tuote tuote : tuotteet) {
            hinta += tuote.getHinta();
        }

        return hinta;
    }
}
