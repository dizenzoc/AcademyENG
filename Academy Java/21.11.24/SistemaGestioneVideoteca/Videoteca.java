import java.util.ArrayList;

public class Videoteca {
    private ArrayList<Film> filmDisponibili;
    private ArrayList<Utente> utentiRegistrati;

    public Videoteca() {
        this.filmDisponibili = new ArrayList<>();
        this.utentiRegistrati = new ArrayList<>();
    }
    
    public void aggiungiFilm(Film film) { // aggiunge un film alla videoteca
        filmDisponibili.add(film);
    }

    public void rimuoviFilm(Film film) { // rimuove un film dalla videoteca
        filmDisponibili.remove(film);
    }

    public void registraUtente(Utente utente) { // registra un nuovo utente
        utentiRegistrati.add(utente);
    }

    public void rimuoviUtente(Utente utente) { // rimuovere un utente dalla videoteca
        if (utentiRegistrati.contains(utente)) {
            if (!utente.getFilmNoleggiati().isEmpty()) { // se l'utente ha film noleggiati
                for (Film film : utente.getFilmNoleggiati()) { // restituisce tutti i film noleggiati
                    filmDisponibili.add(film); // quindi li riaggiungo alla videoteca
                }
                utente.getFilmNoleggiati().clear();
                System.out.println("Tutti i film noleggiati sono stati restituiti.");
            }
            utentiRegistrati.remove(utente); // poi rimuovo l'utente
            System.out.println("Utente rimosso con successo.");
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    public int noleggiaFilm(Utente utente, Film film) { // noleggiare un film
        if (filmDisponibili.contains(film)) {
            if(utente.noleggiaFilm(film)==1) //se effettivamente l'utente puo' noleggiare un film 
                filmDisponibili.remove(film); //allora rimuovo il film da quelli disponibili
                return 1;
        } else {
            return 0;
        }
    }
    
    public int restituisciFilm(Utente utente, Film film) { // restituire un film
        if (utente.getFilmNoleggiati().contains(film)) {
            utente.getFilmNoleggiati().remove(film);
            filmDisponibili.add(film);
            return 1;
        } else {
            return 0;
        }
    }

    public Film cercaFilm(String titolo) { // cercare un film per titolo
        for (Film film : filmDisponibili) {
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                return film;
            }
        }
        return null;
    }

    public ArrayList<Film> cercaFilm(int anno) { // cercare un film per anno
        ArrayList<Film> risultati = new ArrayList<>();
        for (Film film : filmDisponibili) {
            if (film.getAnno() == anno) {
                risultati.add(film);
            }
        }
        return risultati;
    }

    public Utente trovaUtente(String id) { // cercare un utente
        for (Utente utente : utentiRegistrati) {
            if (utente.getID().equals(id)) {
                return utente;
            }
        }
        return null;
    }

    public ArrayList<Film> getFilmDisponibili() {
        return filmDisponibili;
    }

    public ArrayList<Utente> getUtentiRegistrati() {
        return utentiRegistrati;
    }
}
