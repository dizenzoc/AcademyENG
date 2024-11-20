package BibliotecaSemplice;
import java.util.ArrayList;

public class Biblioteca {
    public ArrayList<Libro> libri;


    public Biblioteca() { // costruttore
        this.libri = new ArrayList<>();
    }

    // metodo per aggiungere un libro alla biblioteca
    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    // metodo per stampare tutti i libri
    public void stampaLibri() {
        for (Libro libro : libri) {
            System.out.println("Autore: " + libro.nomeAutore + ", Numero di pagine: " + libro.numeroPagine);
        }
    }

    // Metodo per cercare un libro per autore
    public void cercaPerAutore(String autore) {
        for (Libro libro : libri) {
            if (libro.nomeAutore.equals(autore)) {
                System.out.println("Autore: " + libro.nomeAutore + ", Numero di pagine: " + libro.numeroPagine);
            }
        }
    }

    // Metodo per cercare libri con un massimo di pagine
    public void cercaPerMassimoPagine(int maxPagine) {
        for (Libro libro : libri) {
            if (libro.numeroPagine <= maxPagine) {
                System.out.println("Autore: " + libro.nomeAutore + ", Numero di pagine: " + libro.numeroPagine);
            }
        }
    }
}
