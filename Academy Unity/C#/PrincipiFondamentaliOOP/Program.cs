// Definisci una classe astratta ProdottoSoftware con
// una proprietà nome 
// una proprietà PrezzoVendita
// un metodo astratto CalcolaGuadagno che restituisca un valore decimal

// Crea almeno due sottoclassi concrete (WebApp e MobileApp) che erediteranno da ProdottoSoftware,
// ciscuna con campi aggiuntivi (ad esempio numero utenti, costi mantenimento del server, costi di store online. ecc).
// Implementa CalcolaGuadagno() in modo che, data la tipologia di prodotto, vengano conteggiati i guadagni tenendo
// conto delle spese aggiuntive.

// Incapsula i campi e le proprietà in  modo che non siano direttamente accessibili dall'esterno,
// ma manipolabili tramite metodi e/o proprietà con get e set appropriati

using System;

public abstract class ProdottoSoftware
{
    public string Nome { get; protected set; }
    public decimal PrezzoVendita { get; protected set; }

    public ProdottoSoftware(string nome, decimal prezzoVendita) {
        Nome = nome;
        PrezzoVendita = prezzoVendita;
    }
    public abstract decimal CalcolaGuadagno();
}

class WebApp : ProdottoSoftware
{
    private int numeroUtenti;
    private decimal costoServer;
    public int NumeroUtenti {
        get { return numeroUtenti; }
        set {
            if (value < 0)
                throw new ArgumentException("Il numero di utenti non può essere negativo.");
            numeroUtenti = value;
        }
    }

    public decimal CostoServer {
        get { return costoServer; }
        set {
            if (value < 0)
                throw new ArgumentException("Il costo del server non può essere negativo.");
            costoServer = value;
        }
    }
    public WebApp(string nome, decimal prezzoVendita, int numeroUtenti, decimal costoServer): base(nome, prezzoVendita) {
        NumeroUtenti = numeroUtenti;
        CostoServer = costoServer;
    }
    // non abbiamo notazione override ma si mette prima del tipo di ritorno
    public override decimal CalcolaGuadagno() {
        return (PrezzoVendita * NumeroUtenti) - CostoServer;
    }
}

class MobileApp : ProdottoSoftware
{
    private decimal costoStoreOnline;
    private decimal ricaviPubblicitari;

    public decimal CostoStoreOnline {
        get { return costoStoreOnline; }
        set {
            if (value < 0)
                throw new ArgumentException("Il costo dello store online non può essere negativo.");
            costoStoreOnline = value;
        }
    }

    public decimal RicaviPubblicitari {
        get { return ricaviPubblicitari; }
        set {
            if (value < 0)
                throw new ArgumentException("I ricavi pubblicitari non possono essere negativi.");
            ricaviPubblicitari = value;
        }
    }

    public MobileApp(string nome, decimal prezzoVendita, decimal costoStoreOnline, decimal ricaviPubblicitari) : base(nome, prezzoVendita) {
        CostoStoreOnline = costoStoreOnline;
        RicaviPubblicitari = ricaviPubblicitari;
    }
    //metodo astratto con override
    public override decimal CalcolaGuadagno() {
        return (PrezzoVendita + RicaviPubblicitari) - CostoStoreOnline;
    }
}

class Program
{
    static void Main()
    {
        try
        {
            WebApp webApp = new WebApp("Gestione Progetti", 10.00m, 500, 2000.00m);
            MobileApp mobileApp = new MobileApp("Gioco Mobile", 2.00m, 500.00m, 1500.00m);

            //stampa della WebApp
            Console.WriteLine("WebApp:");
            Console.WriteLine($"Nome: {webApp.Nome}");
            Console.WriteLine($"Numero Utenti: {webApp.NumeroUtenti}");
            Console.WriteLine($"Guadagno: {webApp.CalcolaGuadagno()} €\n");

            //stampa della MobileApp
            Console.WriteLine("MobileApp:");
            Console.WriteLine($"Nome: {mobileApp.Nome}");
            Console.WriteLine($"Guadagno: {mobileApp.CalcolaGuadagno()} €");
        }
        catch (ArgumentException ex) {
            Console.WriteLine($"Errore: {ex.Message}");
        }
    }
}
