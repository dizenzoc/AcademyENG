public class Campionato {
    
    String nomeCampionato;
    ArrayList<Squadra> squadre;

    Campionato(String nomeCampionato) {
        this.nomeCampionato = nomeCampionato;
        squadre = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Squadra squadra = new Squadra("Squadra " + i);
            squadra.generaGiocatori();
            squadre.add(squadra);
        }
    }

    void giocaCampionato() {
        for (int i = 0; i < squadre.size(); i++) {
            for (int j = i + 1; j < squadre.size(); j++) {
                Partita partita = new Partita(squadre.get(i), squadre.get(j));
                partita.giocaPartita();
            }
        }
    }

    void mostraClassifica() {
        Collections.sort(squadre, Comparator.comparingInt(s -> -s.punti));
        System.out.println("Classifica del " + nomeCampionato + ":");
        for (Squadra squadra : squadre) {
            System.out.println(squadra.nomeSquadra + ": " + squadra.punti + " punti");
        }
    }

    void mostraVincitore() {
        Squadra vincitore = Collections.max(squadre, Comparator.comparingInt(s -> s.punti));
        System.out.println("Il vincitore del " + nomeCampionato + " è: " + vincitore.nomeSquadra + " con " + vincitore.punti + " punti!");
    }
}