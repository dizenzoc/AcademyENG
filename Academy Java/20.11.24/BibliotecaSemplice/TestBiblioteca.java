package BibliotecaSemplice;
public class TestBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Creazione di alcuni libri
        Libro libro1 = new Libro("Autore1", 150);
        Libro libro2 = new Libro("Autore2", 200);
        Libro libro3 = new Libro("Autore1", 300);

        // Aggiunta dei libri alla biblioteca
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);

        // Stampa di tutti i libri
        System.out.println("Tutti i libri:");
        biblioteca.stampaLibri();

        // Ricerca per autore
        System.out.println("\nLibri di Autore1:");
        biblioteca.cercaPerAutore("Autore1");

        // Ricerca per massimo pagine
        System.out.println("\nLibri con massimo 200 pagine:");
        biblioteca.cercaPerMassimoPagine(200);
    }
}