import java.util.ArrayList;

public class Ristorante {
    ArrayList<String> piatti = new ArrayList<>();
    ArrayList<Integer> valutazionePiatti = new ArrayList<>();

    ArrayList<Ristorante> utenti = new ArrayList<>();

    public ArrayList<String> getPiatti() {
        return piatti;
    }

    public ArrayList<Integer> getValutazionePiatti() {
        return valutazionePiatti;
    }

    public ArrayList<Ristorante> getUtenti() {
        return utenti;
    }
}