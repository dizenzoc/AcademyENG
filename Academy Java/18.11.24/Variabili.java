public class Variabili {
    public static void main(String[] args){
        final int provaNumero = 15; // final dichiara la variabile come costante, pertanto non puo essere modificato
        boolean provaBool = true;

        System.out.println(provaBool);
        System.out.println(provaNumero);

        String firstPart = "Ciao";
        String lastPart = "Mondo";
        String fullPart = firstPart + lastPart; //concatenazione delle due stringhe
        System.out.println(fullPart);

        //cascata
        int a = 20, b = 30, c = 10;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

        //cascata divisa
        int x, y, z;
        x = y = z = 50;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);

        float myFloat = 5.75f; //bisogna specificare la f
        double myDouble = 19.99d; //bisogna specificare la d
        System.out.println("La variabile float e' inizializzata con: " + myFloat + ", mentre la variabile double e' stata inzializzata con: " + myDouble);
    }
}
