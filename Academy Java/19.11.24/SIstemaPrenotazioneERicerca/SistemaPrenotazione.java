package SIstemaPrenotazioneERicerca;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPrenotazione {
    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in); //scanner interi
        Scanner scStr = new Scanner(System.in); //scanner stringhe

        // Lista di prenotazioni
        ArrayList<ArrayList<String>> prenotazioni = new ArrayList<>();
        
        // Dichiarazione dei posti
        int righe = 3;
        int colonne = 8; 
        
        // Inizializzazione della matrice
        prenotazioni = initMatrix(righe, colonne);

        boolean menu = true;
        while (menu) {
            // Creo un menu per le funzionalita'
            System.out.println("\nMENU PRENOTAZIONE");
            System.out.println("1. Prenota posto specifico.");
            System.out.println("2. Cerca prenotazioni per nome.");
            System.out.println("3. Visualizza posti disponibili e prenotati.");
            System.out.println("4. Visualizza report sui posti.");
            System.out.println("5. Esci dal menu.");
            System.out.print("\nScegli una funzione: ");

            int scelta = scInt.nextInt();
            scInt.nextLine(); // scelta funzione

            switch (scelta) { //creo uno switch per gestire la scelta del menu
                case 1:  // Prenotazione posto
                    System.out.println("Prenotazione:");
                    System.out.print("Inserisci numero riga (0-"+(righe-1)+"): ");
                    int r = scInt.nextInt(); //riga
                    System.out.print("Inserisci numero colonna (0-"+(colonne-1)+"):");
                    int c = scInt.nextInt(); //colonna
                    scInt.nextLine();

                    //controllo se e' un posto esistente
                    if (r >= righe && r < 0 || c >= colonne && c < 0) {
                        System.out.println("Posto inesistente!");
                        break;
                    }
                    else if(prenotazioni.get(r).get(c).equalsIgnoreCase("libero")){ //se il posto e' libero allora inserisco la prenotazione
                        System.out.print("Inserisci il nome del cliente: ");
                        String nomeCliente = scStr.nextLine();
                        // Modifica di un valore specifico
                        prenotazioni.get(r).set(c, nomeCliente);
                        System.out.println("Posto prenotato con successo!");
                    }
                    else{ //se il posto e' occupato allora comunico che il posto e' gia' occupato
                        System.out.println("Posto gia prenotato!");
                    }
                    break;

                case 2: // Cerca prenotazioni per nome
                    System.out.print("Inserisci nome cliente da cercare: ");
                    String nomeDaCercare = scStr.nextLine();
                    boolean esiste = false;

                    // Ricerca del nome nelle prenotazioni
                    for (int i = 0; i < prenotazioni.size(); i++) {
                        for (int j = 0; j < prenotazioni.get(i).size(); j++) {
                            if (prenotazioni.get(i).get(j).equalsIgnoreCase(nomeDaCercare)) {
                                System.out.println("Prenotazione di " + nomeDaCercare + " trovata alla posizione ("+ i + ", " + j + ")");
                                esiste = true;
                                break;
                            }
                        }
                    }
                    if (!esiste) {
                            System.out.println("Nessuna prenotazione trovata per " + nomeDaCercare);
                        }
                    break;

                case 3: //Visualizza posti disponibili e prenotati
                    // Stampa delle prenotazioni
                    // Stampa degli indici delle colonne
                    System.out.print("    ");
                    for (int j = 0; j < prenotazioni.get(0).size(); j++) {
                        System.out.printf("%-10d", j);
                    }
                    System.out.println();
                    for (int i = 0; i < prenotazioni.size(); i++) {
                        System.out.printf("%-4d", i);
                        for (int j = 0; j < prenotazioni.get(i).size(); j++) {
                            System.out.printf("%-10s", prenotazioni.get(i).get(j));
                        }
                        System.out.println();
                    }
                    break;

                case 4: //Visualizza report sui posti
                    break;

                case 5: //Uscita
                    menu = false;
                    System.out.println("Sistema chiuso correttamente!");
                    break;

                default:
                    System.out.println("Nessuna funzionalita' esistente per la scelta inserita. Riprova.");
            }
        }

        scInt.close();
        scStr.close();
    }

    private static ArrayList<ArrayList<String>> initMatrix(int righe, int colonne){
        ArrayList<ArrayList<String>> p = new ArrayList<>(); //prenotazioni
        for (int i = 0; i < righe; i++) {
            ArrayList<String> riga = new ArrayList<>();
            for (int j = 0; j < colonne; j++) {
                riga.add("libero"); // Inzializzo tutto a 0 (indica posto libero)
            }
            p.add(riga);
        }
        return p;
    }
}
