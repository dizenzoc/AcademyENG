import java.util.ArrayList;

public class Utente {

    private final int limit = 3; // costante limite noleggi nel caso in cui non venisse specificata
    
    private String ID;
    private String nome;
    private ArrayList<Film> filmNoleggiati;
    private int limiteNoleggi; // limite di noleggi per utente

    public Utente(){

    }

    public Utente(String idUtente, String nome, int limiteNoleggi) {
        this.ID = idUtente;
        this.nome = nome;
        this.filmNoleggiati = new ArrayList<>();
        this.limiteNoleggi = limiteNoleggi;
    }

    public Utente (String ID, String nome){
        this.ID = ID;
        this.nome = nome;
        this.filmNoleggiati = new ArrayList<>();
        this.limiteNoleggi = limit;
    }

    public Utente (String ID, String nome, ArrayList<Film> filmNoleggiati){
        this.ID = ID;
        this.nome = nome;
        this.filmNoleggiati = filmNoleggiati;
        this.limiteNoleggi = limit;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Film> getFilmNoleggiati() {
        return filmNoleggiati;
    }

    public void setFilmNoleggiati(ArrayList<Film> filmNoleggiati) {
        this.filmNoleggiati = filmNoleggiati;
    }

    public int getLimiteNoleggi() {
        return limiteNoleggi;
    }

    public void setLimiteNoleggi(int limite){
        this.limiteNoleggi = limite;
    }

    public int noleggiaFilm(Film film) {
        if (filmNoleggiati.size() < limiteNoleggi) {
            filmNoleggiati.add(film);
            return 1;
        } else {
            System.out.println("Limite di noleggi raggiunto. Restituisci un film prima di noleggiarne un altro.");
            return 0;
        }
    }

    public void restituisciFilm(Film film) {
        filmNoleggiati.remove(film);
    }

    public void elencoNoleggi() {
        for (Film film : filmNoleggiati) {
            System.out.println(film);
        }
    }

    @Override
    public String toString() {
        return "Utente{" +
                "ID utente='" + ID + '\'' +
                ", nome='" + nome + '\'' +
                ", limiteNoleggi=" + limiteNoleggi +
                ", listaFilmNoleggiati=" + filmNoleggiati +
                '}';
    }
}
