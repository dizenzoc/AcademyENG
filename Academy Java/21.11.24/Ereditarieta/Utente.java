import java.util.Random;

public class Utente extends Ristorante {
    String nome;
    String email;
    int soldi;

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.soldi = 0;
    }

    private int randomizeSoldi() {
        Random rand = new Random();
        return rand.nextInt(100) + 1; // Genera un numero casuale tra 1 e 100
    }

    public void setRandomSoldi() { //aggiorna i soldi randomicamente
        this.soldi = randomizeSoldi();
    }

    public void modificaDati(String nuovoNome, String nuovaEmail) {
        this.nome = nuovoNome;
        this.email = nuovaEmail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }
}