import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args){
        // 3 input nome utente pwd e id
        // check su input

        Scanner scInt, scStr; //dichiaro uno scanner per i numeri e uno per le stringhe
        
        System.out.print("Inserisci l'id utente: ");
        scInt = new Scanner(System.in); //recupero l'id da tastiera
        int id = scInt.nextInt();
        //controllo sull' id
        if (id > 1000)
            System.out.println("WOW! Sembra che siamo parecchi qui!");

        System.out.print("Inserisci il nome utente: ");
        scStr = new Scanner(System.in);
        String username = scStr.nextLine(); //recupero l'username da tastiera
        //controllo sulla lunghezza dell'username
        if (username.length()<3)
            System.out.println("Lunghezza dell'username sembra troppo bassa! Non e' consigliabile inferiore a 3 caratteri");

        System.out.print("Inserisci la password: ");
        String pwd = scStr.nextLine(); //recupero la password da tastiera
        //controllo se la pwd contiene caratteri speciali
        if (pwd.contains("!") || pwd.contains("#") || pwd.contains("@"))
            System.out.println("Ottimo! La password contiene anche dei caratteri speciali");

        System.out.println("Le informazioni inserite sono: ");
        System.out.println("\tid: "+id);
        System.out.println("\tnome utente: "+username);
        System.out.println("\tpassword: "+pwd);

        scInt.close();
        scStr.close();
    }
}
