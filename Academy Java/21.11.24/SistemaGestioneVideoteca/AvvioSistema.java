import java.util.ArrayList;
import java.util.Scanner;

public class AvvioSistema {
    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in); // Scanner per input interi
        Scanner scStr = new Scanner(System.in); // Scanner per input stringhe

        Videoteca videoteca = new Videoteca();

        boolean menu = true;
        while (menu) {
            mostraMenu();

            int scelta = scInt.nextInt();
            scInt.nextLine(); // Consuma la newline

            switch (scelta) {
                case 1:
                    System.out.println();
                    aggiungiFilm(videoteca, scStr);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    registraUtente(videoteca, scStr, scInt);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    noleggiaFilm(videoteca, scStr);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    visualizzaFilmNoleggiatiDaUnUtente(videoteca, scStr);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    restituisciFilm(videoteca, scStr);
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    cercaFilmPerTitolo(videoteca, scStr);
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    cercaFilmPerAnno(videoteca, scInt);
                    System.out.println();
                    break;
                case 8:
                    System.out.println();
                    visualizzaUtentiRegistrati(videoteca);
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    visualizzaFilmDisponibili(videoteca);
                    System.out.println();
                    break;
                case 10:
                    System.out.println();
                    visualizzaFilmInNoleggio(videoteca);
                    System.out.println();
                    break;
                case 11:
                    System.out.println();
                    visualizzaFilmTotali(videoteca);
                    System.out.println();
                    break;
                case 12:
                    menu = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Scelta non valida. Riprova.");
                    System.out.println();
            }
        }

        scInt.close();
        scStr.close();
    }

    private static void mostraMenu() {
        System.out.println("Menu:");
        System.out.println("1. Aggiungi Film");
        System.out.println("2. Registra Utente");
        System.out.println("3. Noleggia Film");
        System.out.println("4. Visualizza film noleggiati da un utente");
        System.out.println("5. Restituisci Film");
        System.out.println("6. Cerca Film per Titolo");
        System.out.println("7. Cerca Film per Anno");
        System.out.println("8. Visualizza Utenti Registrati");
        System.out.println("9. Visualizza Film Disponibili");
        System.out.println("10. Visualizza Film che sono stati Noleggiati");
        System.out.println("11. Visualizza tutti i film di proprieta' della Videoteca");
        System.out.println("12. Esci");
        System.out.print("Scegli un'opzione: ");
    }

    private static void aggiungiFilm(Videoteca videoteca, Scanner scStr) {
        System.out.print("Inserisci il titolo del film: ");
        String titolo = scStr.nextLine();
        System.out.print("Inserisci l'anno di uscita del film: ");
        int anno = scStr.nextInt();
        scStr.nextLine();

        Film film = new Film(titolo, anno);
        videoteca.aggiungiFilm(film);
        System.out.println("Film aggiunto con successo.");
    }

    private static void registraUtente(Videoteca videoteca, Scanner scStr, Scanner scInt) {
        System.out.print("Inserisci l'ID utente: ");
        String idUtente = scStr.nextLine();
        System.out.print("Inserisci il nome dell'utente: ");
        String nome = scStr.nextLine();
        System.out.print("Inserisci il limite di noleggi per l'utente: ");
        int limiteNoleggi = scInt.nextInt();
        scInt.nextLine();

        Utente utente = new Utente(idUtente, nome, limiteNoleggi);
        videoteca.registraUtente(utente);
        System.out.println("Utente registrato con successo.");
    }

    private static void noleggiaFilm(Videoteca videoteca, Scanner scStr) {
        System.out.print("Inserisci l'ID utente: ");
        String idUtente = scStr.nextLine();
        Utente utente = videoteca.trovaUtente(idUtente);

        if (utente != null) {
            System.out.print("Inserisci il titolo del film da noleggiare: ");
            String titolo = scStr.nextLine();
            Film film = videoteca.cercaFilmDisponibili(titolo);
            if (film != null) {
                if(videoteca.noleggiaFilm(utente, film) == 1){
                    System.out.println("Film noleggiato con successo.");
                }else{
                    System.out.println("Film non disponibile.");
                }
            } else {
                System.out.println("Film non trovato.");
            }
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    private static void visualizzaFilmNoleggiatiDaUnUtente(Videoteca videoteca, Scanner scStr){
        System.out.print("Inserisci l'ID utente: ");
        String idUtente = scStr.nextLine();
        Utente utente = videoteca.trovaUtente(idUtente);

        if (utente != null) {
            ArrayList<Film> filmNoleggiati = utente.getFilmNoleggiati();
            if (!filmNoleggiati.isEmpty()) {
                System.out.println("Film noleggiati dall'utente " + utente.toString() + ": ");
                for (Film film : filmNoleggiati) {
                    System.out.println(film);
                }
            }
            else{
                System.out.println("Non ci sono film noleggiati da questo utente.");
            }

        } else {
            System.out.println("Utente non trovato.");
        }
    }

    private static void restituisciFilm(Videoteca videoteca, Scanner scStr) {
        System.out.print("Inserisci l'ID utente: ");
        String idUtente = scStr.nextLine();
        Utente utente = videoteca.trovaUtente(idUtente);

        if (utente != null) {
            System.out.print("Inserisci il titolo del film da restituire: ");
            String titolo = scStr.nextLine();
            Film film = videoteca.cercaFilmInNoleggio(titolo);

            if (film != null) {
                if(videoteca.restituisciFilm(utente, film) == 1){
                    System.out.println("Film restituito con successo.");
                }
                else{
                    System.out.println("Il film non è stato noleggiato da questo utente.");
                }
            } else {
                System.out.println("Film non trovato.");
            }
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    private static void cercaFilmPerTitolo(Videoteca videoteca, Scanner scStr) { //cerco solo tra i film disponibili
        System.out.print("Inserisci il titolo del film: ");
        String titolo = scStr.nextLine();
        Film film = videoteca.cercaFilmDisponibili(titolo);

        if (film != null) {
            System.out.println("Film trovato: " + film);
        } else {
            System.out.println("Film non trovato.");
        }
    }

    private static void cercaFilmPerAnno(Videoteca videoteca, Scanner scInt) { //cerco solo tra i film disponibili
        System.out.print("Inserisci l'anno di uscita del film: ");
        int anno = scInt.nextInt();
        ArrayList<Film> risultati = videoteca.cercaFilmDisponibili(anno);

        if (!risultati.isEmpty()) {
            System.out.println("Film trovati:");
            for (Film film : risultati) {
                System.out.println(film);
            }
        } else {
            System.out.println("Nessun film trovato per l'anno specificato.");
        }
    }

    private static void visualizzaUtentiRegistrati(Videoteca videoteca) {
        ArrayList<Utente> utenti = videoteca.getUtentiRegistrati();
        if (!utenti.isEmpty()) {
            System.out.println("Utenti registrati:");
            for (Utente utente : utenti) {
                System.out.println(utente);
            }
        } else {
            System.out.println("Nessun utente registrato.");
        }
    }

    private static void visualizzaFilmDisponibili(Videoteca videoteca) {
        ArrayList<Film> film = videoteca.getFilmDisponibili();
        if (!film.isEmpty()) {
            System.out.println("Film disponibili:");
            for (Film f : film) {
                System.out.println(f);
            }
        } else {
            System.out.println("Nessun film disponibile.");
        }
    }

    private static void visualizzaFilmInNoleggio(Videoteca videoteca) {
        ArrayList<Film> film = videoteca.getFilmInNoleggio();
        if (!film.isEmpty()) {
            System.out.println("Film consegnati in noleggio:");
            for (Film f : film) {
                System.out.println(f);
            }
        } else {
            System.out.println("Nessun film consegnato in noleggio.");
        }
    }

    private static void visualizzaFilmTotali(Videoteca videoteca) {
        ArrayList<Film> filmDisponibili = videoteca.getFilmDisponibili();
        ArrayList<Film> filmInNoleggio = videoteca.getFilmInNoleggio();
    
        if (!filmDisponibili.isEmpty() || !filmInNoleggio.isEmpty()) {
            System.out.println("Tutti i film:");
            for (Film film : filmDisponibili) {
                System.out.println("Disponibile: " + film);
            }
            for (Film film : filmInNoleggio) {
                System.out.println("In noleggio: " + film);
            }
        } else {
            System.out.println("Nessun film disponibile o in noleggio.");
        }
    }
}