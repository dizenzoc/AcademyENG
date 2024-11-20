import java.util.ArrayList;
import java.util.Random;

class Squadra {
    final int numeroCalciatori = 12;

    String nomeSquadra;
    ArrayList<Calciatore> calciatori;
    String[] nomi = {"GiocatoreA", "GiocatoreB", "GiocatoreC", "GiocatoreD", "GiocatoreE", "GiocatoreF", "GiocatoreG", "GiocatoreH", "GiocatoreI", "GiocatoreJ", "GiocatoreK", "GiocatoreL"};
    String[] ruoli = {"Portiere", "Difensore", "Centrocampista", "Attaccante"};

    Squadra(String nomeSquadra) {
        this.nomeSquadra = nomeSquadra;
        this.calciatori = new ArrayList<>();
    }

    void aggiungiCalciatore(Calciatore calciatore) {
        if (calciatori.size() < 12) {
            calciatori.add(calciatore);
        } else {
            System.out.println("La squadra è già completa.");
        }
    }

    void generaGiocatori() {
        Random random = new Random();
        for (int i = 0; i < numeroCalciatori; i++) {
            String nome = nomi[i];
            String ruolo = ruoli[random.nextInt(ruoli.length)];
            aggiungiCalciatore(new Calciatore(nome, ruolo));
        }
    }
}