import java.util.Scanner;

public class Esercizio1_Array {
    //ESERCIZIO1 ma UTILLIZARE ARRAY
    public static void main(String[] args){
        Scanner scInt;
        int num [] = new int[5];
        int somma = 0; //inizializzo variabile per la somma

        //utilizziamo un for per riempire l'array con 5 interi (positivi e negativi)
        for (int i = 0; i < 5; i++) {
                System.out.print("\nInserisci un numero (termina dopo 5 inserimenti): ");
                scInt = new Scanner(System.in); 
                num[i] = scInt.nextInt(); //recupero l'intero da tastiera inserendolo direttamente nell'array
        }

        System.out.println("\nControlliamo gli input inseriti!!");
        for (int numero : num) {
            somma += numero; //eseguo somma dei numeri presenti in num
            if ((numero%2)==0) //controllo se numero e' pari o dispari
                System.out.println(numero+" e\' un numero pari");
            else
                System.out.println(numero+" e\' un numero dispari");
        }
        if (somma < 0) //comunico il risultato controllando se la somma e' negativa
            System.out.println("\nComplimenti, hai terminato correttamente!");
        else
            System.out.println("\nOps, qualcosa e\' andato storto!");
    }
}


