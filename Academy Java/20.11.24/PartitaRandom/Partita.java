import java.util.Random;

public class Partita {
    Squadra squadra1;
    Squadra squadra2;
    int goalSquadra1;
    int goalSquadra2;

    Partita(Squadra squadra1, Squadra squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
        this.goalSquadra1 = 0;
        this.goalSquadra2 = 0;
    }

    void giocaPartita() {
        Random random = new Random();
        goalSquadra1 = random.nextInt(6); // numero di gol tra 0 e 5
        goalSquadra2 = random.nextInt(6); // numero di gol tra 0 e 5

        if (goalSquadra1 > goalSquadra2) {
            squadra1.punti += 3;
        } else if (goalSquadra1 < goalSquadra2) {
            squadra2.punti += 3;
        } else {
            squadra1.punti += 1;
            squadra2.punti += 1;
        }
    }

    void mostraRisultato() {
        System.out.println(squadra1.nomeSquadra + " " + goalSquadra1 + " - " + goalSquadra2 + " " + squadra2.nomeSquadra);
    }

    void mostraRisultato(int goalSquadra1, int goalSquadra2){
        int differenzaGoal = goalSquadra1 - goalSquadra2;
        if (differenzaGoal > 0) {
            System.out.println(squadra1.nomeSquadra + " vince!");
        } else if (differenzaGoal < 0) {
            System.out.println(squadra2.nomeSquadra + " vince!");
        } else {
            System.out.println("Partita terminata in pareggio!");
        }
    }
}