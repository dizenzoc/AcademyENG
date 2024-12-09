//Scrivi un programma in C# che chieda all'utente di inserire una frase.
//Il programma deve quindi contare e stampare il numero di parole presenti nella
//frase inserita. Considera che le parole sono separate da spazi.
// Non è richiesto inserire i codici per la gestione di input non validi.

using System;
class Program
{
    static void Main()
    {
        Console.WriteLine("Inserisci una frase:"); // chiedo all'utente di inserire una frase
        string frase = Console.ReadLine();
        
        string[] parole = frase.Split(' '); // suddivido la frase in parole 'spezzando' sugli spazi

        int numeroParole = parole.Length; // conto il numero di parole

        Console.WriteLine($"La frase contiene {numeroParole} parole."); // stampo il numero di parole
    }
}
