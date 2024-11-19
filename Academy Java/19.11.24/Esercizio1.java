import java.util.Scanner;

public class Esercizio1 {
    /* Scrivi un programma che continua a chiedere all'utente di inserire un numero
        fino a quando l'utente inserisce un numero negativo. 
        Durante ogni iterazione, controlla con un if se il numero
        è pari o dispari e stampalo.
        
        Chiedi all'utente di inserire un numero.
        Continua a chiedere il numero finché l'utente non inserisce un numero negativo.
        Usa if per verificare se il numero è pari o dispari.
        Stampa il risultato. */
    public static void main(String[] args){
        Scanner scInt; //dichiaro uno scanner per i numeri e uno per le stringhe
        int num;
        
        do{
            System.out.print("\nInserisci un numero (per terminare inserisci un numero negativo): ");
            scInt = new Scanner(System.in); 
            num = scInt.nextInt(); //recupero l'intero da tastiera
        
            if ((num%2)==0 && num >= 0) //controllo se num e' pari o dispari e che non sia negativo
                System.out.println(num+" e\' un numero pari");
            else if((num%2)!=0 && num >= 0)
                System.out.println(num+" e\' un numero dispari");
            else
                System.out.println("Complimenti, hai terminato!");

        }while(num >= 0); //continuo finche' il num non e' negativo
       
        scInt.close();
    }
}


