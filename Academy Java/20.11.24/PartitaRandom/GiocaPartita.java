public class GiocaPartita {
    public static void main(String[] args) {
        Squadra squadra1 = new Squadra("SquadraA");
        Squadra squadra2 = new Squadra("SquadraB");

        squadra1.generaGiocatori(); //genero giocatori per la squadra1
        squadra2.generaGiocatori(); //genero giocatori per la squadra2

        Partita partita = new Partita(squadra1, squadra2);
        partita.giocaPartita(); //gioco la partita
        partita.mostraRisultato(); //mostro il risultato in due modi differenti
        partita.mostraRisultato(partita.goalSquadra1, partita.goalSquadra2); 
    }
}