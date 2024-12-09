//SCRIVERE un programma in C# che legga da tastiera un numero intero, verifichi se è pari o dispari 
//e stampi in console un messaggio che indichi il risultato aggiungendolo ad una collezione e chieda
//se stampare i numeri pari o dispari. Non è richiesto inserire i codici per la gestione di input non validi 

using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        // collezioni per numeri pari e dispari
        List<int> numeriPari = new List<int>();
        List<int> numeriDispari = new List<int>();

        while (true) { //inserisco numeri fin quando l'utente non digita 'esci'
            Console.WriteLine("Inserisci un numero intero (scrivi 'esci' per terminare):");
            string input = Console.ReadLine();

            if (input.ToLower() == "esci") { //se input è uguale ad 'esci' allora mi fermo
                break;
            }
            
            int numero = int.Parse(input); // converto l'input in un numero intero

            if (numero % 2 == 0){ // Verifica se il numero è pari o dispari
                Console.WriteLine($"Il numero {numero} è pari.");
                numeriPari.Add(numero);
            }
            else {
                Console.WriteLine($"Il numero {numero} è dispari.");
                numeriDispari.Add(numero);
            }
        }
        if(numeriPari.Count > 0 || numeriDispari.Count > 0){// chiedo quale lista stampare solo se almeno una delle due liste contiene almeno un elemento
            Console.WriteLine("Vuoi stampare i numeri pari o dispari? (scrivi 'pari' o 'dispari')"); 
            string scelta = Console.ReadLine();

            if (scelta.ToLower() == "pari") { // se la risposta è 'pari'
                if(numeriPari.Count > 0){ //mostro i numeri in collezione solo se presenti
                    Console.WriteLine("Numeri pari:");
                    foreach (int numero in numeriPari) { //scorro la collezione pari per stampare i numeri pari
                        Console.WriteLine(numero);
                    }
                }
                else {
                    Console.WriteLine("Non ci sono numeri pari");
                }
            }
            else if (scelta.ToLower() == "dispari") { // se la risposta è 'dipari'
                if(numeriDispari.Count > 0) { //mostro i numeri in collezione solo se presenti
                    Console.WriteLine("Numeri dispari:");
                    foreach (int numero in numeriDispari) { //scorro la collezione dipari per stampare i numeri dipari
                        Console.WriteLine(numero);
                    }
                }
                else {
                    Console.WriteLine("Non ci sono numeri dipari");
                }
            }
            else { // se non è ne 'pari' ne 'dispari' allora la scelta non è valida
                Console.WriteLine("Scelta non valida. Programma terminato.");
            }
        }
        else {
            Console.WriteLine("Non ci sono elementi da mostrare!");
        }
        
    }
}
