public class EsempiMetodi {
    public static void main(String[] args){
        int a = 5;
        int b = 4;

        esempioMetodoSenzaParametri();

        System.out.println("La somma tra " + a + " e " + b + " e\': " + somma(a, b) + "\n");

        int risultato = metodoConParametriVarargs(1, 2, 3, 4, 5);
        System.out.println("Somma con metodo avente parametri varargs: " + risultato);

    }

    private static void esempioMetodoSenzaParametri(){
        System.out.println("Questa stampa si trova all'interno di un metodo void senza parametri!\n");
    }

    private static int somma (int a, int b){
        return a + b;
    }

    private static int metodoConParametriVarargs(int... numeri){
        int somma = 0;
        for (int numero : numeri) {
            somma += numero;
        }
        return somma;

    }
}
