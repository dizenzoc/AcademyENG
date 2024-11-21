import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome:");
        String nome = scanner.nextLine();
        System.out.print("Inserisci la tua email:");
        String email = scanner.nextLine();
        
        Utente utenteInInput = new Utente(nome, email);

        Utente utente = new Utente("Federico", "fedex");

        if (!login(utenteInInput, utente)) {
            System.exit(1);
        }
        
        System.out.println("\nBenvenuto, " + utente.nome + "! Hai " + utente.soldi + " soldi.");

        boolean sceltaValida = false;
        while (!sceltaValida) {
            System.out.println("\nVuoi diventare Chef o Critico? \n1. Chef \n2. Critico");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    Chef chef = new Chef(nome, email);
                    sceltaValida = true;
                    gestisciUtente(scanner, chef);
                    break;
                case 2:
                    Critico critico = new Critico(nome, email);
                    sceltaValida = true;
                    gestisciUtente(scanner, critico);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }

    private static void gestisciUtente(Scanner scanner, Utente utente) {
        boolean menu = true;
        while (menu) {
            mostraMenu(utente);
            int operazione = scanner.nextInt();
            scanner.nextLine();

            switch (operazione) {
                case 1:
                    stampaDati(utente);
                    if (utente instanceof Chef) {
                        ((Chef) utente).stampaPiattiCreati();
                    } else if (utente instanceof Critico) {
                        ((Critico) utente).stampaRecensioniFatte();
                    }
                    break;
                case 2:
                    modificaDati(scanner, utente);
                    break;
                case 3:
                    if (utente instanceof Chef) {
                        System.out.println("Aggiungi un piatto:");
                        String piatto = scanner.nextLine();
                        ((Chef) utente).aggiungiPiatto(piatto);
                        System.out.println("Piatto aggiunto!");
                    } else if (utente instanceof Critico) {
                        System.out.println("Valuta un piatto (1-5):");
                        int valutazione = scanner.nextInt();
                        scanner.nextLine();
                        ((Critico) utente).valutaPiatto(valutazione);
                        System.out.println("Valutazione aggiunta!");
                    }
                    break;
                case 4:
                    menu = false;
                    break;
                default:
                    System.out.println("Operazione non valida. Riprova.");
            }
        }
    }

    private static boolean login (Utente u1, Utente u2){
        if (u1.getNome().equals(u2.getNome()) && u1.getEmail().equals(u2.getEmail())) {
            u2.setRandomSoldi(); //aggiorno i soldi randomicamente
            return true;
        }
        else
            return false;
    }

    private static void mostraMenu(Utente utente) {
        System.out.println("\nScegli un'operazione:");
        System.out.println("1. Stampa i dati");
        System.out.println("2. Modifica i dati");
        if (utente instanceof Chef) {
            System.out.println("3. Aggiungi un piatto");
        } else if (utente instanceof Critico) {
            System.out.println("3. Valuta un piatto");
        }
        System.out.println("5. Esci");
    }

    private static void stampaDati(Utente utente) {
        System.out.println("Nome: " + utente.nome);
        System.out.println("Email: " + utente.email);
        System.out.println("Soldi: " + utente.soldi);
    }

    private static void modificaDati(Scanner scanner, Utente utente) {
        boolean modificaValida = false;
        while (!modificaValida) {
            System.out.println("\nCosa vuoi modificare?");
            System.out.println("1. Nome");
            System.out.println("2. Email");
            System.out.println("3. Annulla");
            int scelta = scanner.nextInt();
            scanner.nextLine();
    
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nuovo nome:");
                    String nuovoNome = scanner.nextLine();
                    utente.modificaDati(nuovoNome, utente.email);
                    System.out.println("Nome aggiornato!");
                    modificaValida = true;
                    break;
                case 2:
                    System.out.println("Inserisci la nuova email:");
                    String nuovaEmail = scanner.nextLine();
                    utente.modificaDati(utente.nome, nuovaEmail);
                    System.out.println("Email aggiornata!");
                    modificaValida = true;
                    break;
                case 3:
                    modificaValida = true;
                    System.out.println("Modifica annullata.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}