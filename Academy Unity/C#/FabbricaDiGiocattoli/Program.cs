// Crea una classe Giocatolo che rappresenti un giocatolo prodotto in una fabbrica. La classe deve contenere le seguenti proprietà:
//  nome
//  tipo (del materiale)
//  prezzo di produzione
//  prezzo di vendita
// La classe deve avere almeno un costruttore per inizializzare le propiretà. 
// Realizza Poi una seconda classe FabbricaGiocattoli Che gestisce una lista di giocattoli prodotti. 
// La fabbrica deve essere in grado di:
//     Aggiungere nuovi giocattoli alla lista;
//     Stampare a Video l'elenco dei giocattoli disponibili, indicando per ciascuno nome, tipo e prezzo di vendita;
//     Calcolare il guadagno netto totale (differenza tra prezzo di vendita e prezzo di produzione di ogni giocattolo) 
//     di tutti i giocattoli prodotti.

using System;
using System.Collections.Generic;

class Giocattolo
{
    // proprietà
    public string Nome { get; set; }
    public string Tipo { get; set; }
    public decimal PrezzoProduzione { get; set; }
    public decimal PrezzoVendita { get; set; }

    // costruttore
    public Giocattolo(string nome, string tipo, decimal prezzoProduzione, decimal prezzoVendita) {
        Nome = nome;
        Tipo = tipo;
        PrezzoProduzione = prezzoProduzione;
        PrezzoVendita = prezzoVendita;
    }
}

class FabbricaGiocattoli
{
    private List<Giocattolo> giocattoli; // lista di giocattoli 

    // costruttore
    public FabbricaGiocattoli() {
        giocattoli = new List<Giocattolo>();
    }

    // aggiunta di un giocattolo
    public void aggiungiGiocattolo(Giocattolo nuovoGiocattolo) {
        giocattoli.Add(nuovoGiocattolo);
        Console.WriteLine($"Giocattolo '{nuovoGiocattolo.Nome}' aggiunto alla lista.");
    }

    // stampa elenco giocattoli
    public void stampaElencoGiocattoli() {
        Console.WriteLine("Elenco dei giocattoli disponibili:");
        foreach (Giocattolo giocattolo in giocattoli)
        {
            Console.WriteLine($"- Nome: {giocattolo.Nome}, Tipo: {giocattolo.Tipo}, Prezzo di vendita: {giocattolo.PrezzoVendita} €");
        }
    }

    // Metodo per calcolare il guadagno netto totale
    public decimal calcolaGuadagnoNettoTotale() {
        decimal guadagnoTotale = 0;
        foreach (Giocattolo giocattolo in giocattoli) {
            guadagnoTotale += giocattolo.PrezzoVendita - giocattolo.PrezzoProduzione;
        }
        return guadagnoTotale;
    }
}

class Program
{
    static void Main()
    {
        FabbricaGiocattoli fabbrica = new FabbricaGiocattoli();

        while (true) { //finche l'utente non scrive 'exit' continuo a chiedere di inserire giocattoli
            Console.WriteLine("Inserisci il nome del giocattolo ('exit' per terminare):");
            string nome = Console.ReadLine(); //nome
            
            if (nome.ToLower() == "exit") // se l'utente ha scritto "exit", esco dal ciclo
                break;

            Console.WriteLine("Inserisci il tipo di materiale del giocattolo:");
            string tipo = Console.ReadLine(); //tipo di materiale

            decimal prezzoProduzione;
            while (true) {
                Console.WriteLine("Inserisci il prezzo di produzione:");
                if (decimal.TryParse(Console.ReadLine(), out prezzoProduzione)) {//prezzo di produzione
                    break; // valore valido, esco dal ciclo
                }
                else {
                    Console.WriteLine("Input non valido. Inserisci un numero valido per il prezzo di produzione.");
                }
            }

            decimal prezzoVendita;
            while (true) {
                Console.WriteLine("Inserisci il prezzo di vendita:");
                if (decimal.TryParse(Console.ReadLine(), out prezzoVendita)) {//prezzo di vendita
                    break; // valore valido, esco dal ciclo
                }
                else {
                    Console.WriteLine("Input non valido. Inserisci un numero valido per il prezzo di vendita.");
                }
            }

            fabbrica.aggiungiGiocattolo(new Giocattolo(nome, tipo, prezzoProduzione, prezzoVendita)); //aggiungo giocattolo alla fabbrica
        }

        fabbrica.stampaElencoGiocattoli(); // stampa elenco giocattoli
        
        decimal guadagnoNettoTotale = fabbrica.calcolaGuadagnoNettoTotale(); // calcolo 
        Console.WriteLine($"\nIl guadagno netto totale è: {guadagnoNettoTotale} €"); //e mostra il guadagno netto totale
    }
}
