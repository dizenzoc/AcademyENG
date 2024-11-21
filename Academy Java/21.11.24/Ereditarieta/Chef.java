import java.util.ArrayList;

public class Chef extends Utente {
    ArrayList<String> piattiCreati = new ArrayList<>();

    public Chef(String nome, String email) {
        super(nome, email);
    }

    public void aggiungiPiatto(String piatto) {
        piatti.add(piatto);
        piattiCreati.add(piatto);
    }

    public void stampaPiattiCreati() {
        System.out.println("Piatti creati da " + nome + ": " + piattiCreati);
    }
}