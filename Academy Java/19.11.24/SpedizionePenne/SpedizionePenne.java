package SpedizionePenne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpedizionePenne {
    public static void main(String[] args) {
        final int colonne = 5;

        Scanner scInt = new Scanner(System.in); //scanner interi

        // Lista di prenotazioni
        ArrayList<ArrayList<String>> spedizioni = new ArrayList<>();
        
        ArrayList<String> intestazioni = definisciIntestazioni(colonne, "id_spedizione", "penne_nere", "penne_rosse", "penne_blu", "penne_verdi");     
        spedizioni.add(intestazioni);// aggiungo le intestazioni come prima riga della matrice

        boolean menu = true;
        while (menu) {
            mostraMenu();
            
            int scelta = scInt.nextInt();
            scInt.nextLine(); // Consuma la newline

            switch (scelta) {
                case 1:
                    nuovaSpedizione(spedizioni);
                    break;
                case 2:
                    stampaSpedizioni(spedizioni);
                    break;
                case 3:
                    stampaTotalePennePerColore(spedizioni);
                    break;
                case 4:
                    cercaSpedizionePerColore(spedizioni);
                    break;
                case 5:
                    menu = esciDalMenu();
                    break;
                default:
                    sceltaNonValida();
            }
        }

        scInt.close();
    }

    private static ArrayList<String> definisciIntestazioni(int colonne, String... intestazioni) {
        ArrayList<String> listaIntestazioni = new ArrayList<>(Arrays.asList(intestazioni)); // converto l'array di intestazioni in una lista
        
        // mi assicuro che il numero di intestazioni corrisponda al numero di colonne
        if (listaIntestazioni.size() != colonne) { // Supponendo che il numero di colonne sia sempre 5
            System.out.println("Il numero di intestazioni deve essere uguale al numero di colonne.");
            System.exit(1); // Termina il programma con un codice di errore
        }

        return listaIntestazioni;
    }

    private static void mostraMenu(){
        // Creo un menu per le funzionalita'
        System.out.println("\nMENU SPEDIZIONI");
        System.out.println("1. Aggiungi spedizione.");
        System.out.println("2. Visualizza tutte le spedizioni.");
        System.out.println("3. Calcola totale di penne di ogni colore.");
        System.out.println("4. Ricerca per colore.");
        System.out.println("5. Esci dal menu.");
        System.out.print("\nScegli una funzione: ");
    }

    private static boolean esciDalMenu() {
        System.out.println("Sistema chiuso correttamente! Grazie per averci scelto.");
        return false;
    }

    private static void sceltaNonValida() {
        System.out.println("Nessuna funzionalità esistente per la scelta inserita. Riprova.");
    }

    private static void nuovaSpedizione(ArrayList<ArrayList<String>> spedizioni) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> nuovaSpedizione = new ArrayList<>(); //dichiaro array per la nuova spedizione

        System.out.print("Inserisci id_spedizione: ");
        String idSpedizione = scanner.nextLine(); //chiedo input id spedizione
        nuovaSpedizione.add(idSpedizione);

        System.out.print("Inserisci numero di penne nere: ");
        String penneNere = scanner.nextLine(); //chiedo input penne nere
        nuovaSpedizione.add(penneNere);

        System.out.print("Inserisci numero di penne rosse: ");
        String penneRosse = scanner.nextLine(); //chiedo input penne rosse
        nuovaSpedizione.add(penneRosse);

        System.out.print("Inserisci numero di penne blu: ");
        String penneBlu = scanner.nextLine(); //chiedo input penne blu
        nuovaSpedizione.add(penneBlu);

        System.out.print("Inserisci numero di penne verdi: ");
        String penneVerdi = scanner.nextLine(); //chiedo input penne verdi
        nuovaSpedizione.add(penneVerdi);

        spedizioni.add(nuovaSpedizione); // aggiungo la nuova spedizione alla matrice
        System.out.println("Spedizione aggiunta con successo!");
    }

    private static void stampaSpedizioni(ArrayList<ArrayList<String>> spedizioni) {
        // detrmina la larghezza massima di ogni colonna
        // ovviamente mi sono aiutato per la formattazione della stampa
        int[] larghezzaColonne = new int[spedizioni.get(0).size()];
        for (ArrayList<String> riga : spedizioni) {
            for (int i = 0; i < riga.size(); i++) {
                larghezzaColonne[i] = Math.max(larghezzaColonne[i], riga.get(i).length());
            }
        }
    
        // stampo ogni riga con le colonne allineate.
        for (ArrayList<String> riga : spedizioni) {
            for (int i = 0; i < riga.size(); i++) {
                System.out.print(String.format("%-" + (larghezzaColonne[i] + 2) + "s", riga.get(i)));
            }
            System.out.println();
        }
    }

    // Mi sono reso conto che questo metodo non mi sarebbe servito, commento perche potrebbe servirmi successivamente :)
    // private static int getNumeroSpedizioni(ArrayList<ArrayList<String>> spedizioni) {
    //     return spedizioni.size() - 1; // Sottraggo 1 per escludere la riga delle intestazioni
    // }

    private static int getPenneBlu(ArrayList<ArrayList<String>> spedizioni) {
        return getTotalePennePerColore(spedizioni, "penne_blu");
    }

    private static int getPenneNere(ArrayList<ArrayList<String>> spedizioni) {
        return getTotalePennePerColore(spedizioni, "penne_nere");
    }

    private static int getPenneRosse(ArrayList<ArrayList<String>> spedizioni) {
        return getTotalePennePerColore(spedizioni, "penne_rosse");
    }

    private static int getPenneVerdi(ArrayList<ArrayList<String>> spedizioni) {
        return getTotalePennePerColore(spedizioni, "penne_verdi");
    }

    private static int getTotalePennePerColore(ArrayList<ArrayList<String>> spedizioni, String colore) {
        int totale = 0;
        int colonna = spedizioni.get(0).indexOf(colore); // Trova l'indice della colonna
        if (colonna == -1) { // se il colore non è valido
            System.exit(1); // termina il programma con un codice di errore
        }
        for (int i = 1; i < spedizioni.size(); i++) { // inizio da 1 per saltare le intestazioni
            totale += Integer.parseInt(spedizioni.get(i).get(colonna));
        }
        return totale;
    }

    private static void stampaTotalePennePerColore(ArrayList<ArrayList<String>> spedizioni) {
        int totalePenneNere = getPenneNere(spedizioni);
        int totalePenneRosse = getPenneRosse(spedizioni);
        int totalePenneBlu = getPenneBlu(spedizioni);
        int totalePenneVerdi = getPenneVerdi(spedizioni);

        System.out.println("Totale penne nere: " + totalePenneNere);
        System.out.println("Totale penne rosse: " + totalePenneRosse);
        System.out.println("Totale penne blu: " + totalePenneBlu);
        System.out.println("Totale penne verdi: " + totalePenneVerdi);
    }

    private static ArrayList<ArrayList<String>> cercaSpedizioneConPennaColorata(ArrayList<ArrayList<String>> spedizioni, String colore) {
        ArrayList<ArrayList<String>> risultato = new ArrayList<>();
        int colonna = spedizioni.get(0).indexOf(colore); // Trova l'indice della colonna che corrisponde al colore specificato.
        
        if (colonna == -1) { // Se il colore non viene trovato
            System.out.println("Colore non valido: " + colore);
            System.exit(1); // Termina il programma con un codice di uscita 1.
        }
        
        risultato.add(spedizioni.get(0)); // aggiungo le intestazioni al risultato
        
        for (int i = 1; i < spedizioni.size(); i++) { // Inizia da 1 per saltare le intestazioni
            if (Integer.parseInt(spedizioni.get(i).get(colonna)) > 0) { // se la quantità della penna del colore specificato è maggiore di 0.
                risultato.add(spedizioni.get(i)); // aggiungo la spedizione al risultato
            }
        }
        return risultato;
    }

    private static void cercaSpedizionePerColore(ArrayList<ArrayList<String>> spedizioni) {
        String colore = chiediColore(); // Chiede all'utente di inserire il colore desiderato.

        // Cerca le spedizioni che contengono penne del colore specificato.
        ArrayList<ArrayList<String>> risultato = cercaSpedizioneConPennaColorata(spedizioni, "penne_" + colore);
        
        if (risultato.size() > 1) { // Se ci sono spedizioni trovate (oltre alle intestazioni)
            System.out.println("Spedizioni con penne " + colore + ":"); 
            stampaSpedizioni(risultato); // le stampa.
        } else {
            System.out.println("Nessuna spedizione trovata con penne " + colore + ".");
        }
    }

    private static String chiediColore() {
        Scanner scStr = new Scanner(System.in);
        String colore;
        boolean coloreValido;
    
        do {
            // chiedo all'utente di inserire il colore desiderato.
            System.out.print("Inserisci il colore delle penne da cercare (nere, rosse, blu, verdi): ");
            colore = scStr.nextLine().toLowerCase();
            
            // verifico se il colore inserito è valido (tra quelli specificati).
            coloreValido = Arrays.asList("nere", "rosse", "blu", "verdi").contains(colore);
            
            if (!coloreValido) {
                // informo l'utente che il colore inserito non è valido e richiedo nuovamente l'input.
                System.out.println("Colore non valido: " + colore + ". Per favore, inserisci un colore valido.");
            }
        } while (!coloreValido); // continuo a chiedere finché il colore non è valido.
        
        return colore;
    }

}


