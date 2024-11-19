import java.util.Arrays;

public class EsempiArray {
    public static void main(String[] args){
        //ARRAY
        int[] numeri = {10, 20, 30, 40, 50}; //numeri e' un array che contiene 5 numeri

        System.out.println("Sto stampando il numero in posizione 1: " + numeri[1]);

        //metodo (proprieta') length
        System.out.println("\nStampa numeri con for:");
        System.out.println("I numeri contenuti nell'array sono: ");
        for (int i = 0; i < numeri.length; i++) {
            System.out.println("\t"+numeri[i]);
        }

        // metodo toString() - Stampa dell'array come stringa
        System.out.println("\nStampa array con toSTring():");
        System.out.println("Array: " + Arrays.toString(numeri)); // Output: Array: [10, 20, 30, 40, 50]

        //FOR_EACH
        System.out.println("\nStampa numeri con foreach:");
        for (int numero : numeri)
            System.out.println("\tNumero: " + numero);
    }
}
