import java.util.ArrayList;

public class Critico extends Utente {
    ArrayList<Integer> recensioniFatte = new ArrayList<>();

    public Critico(String nome, String email) {
        super(nome, email);
    }

    public void valutaPiatto(int valutazione) {
        valutazionePiatti.add(valutazione);
        recensioniFatte.add(valutazione);
    }

    public void stampaRecensioniFatte() {
        System.out.println("Recensioni fatte da " + nome + ": " + recensioniFatte);
    }
}