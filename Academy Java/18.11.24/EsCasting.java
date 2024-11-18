public class EsCasting {
    public static void main(String[] args){
        // ESISTONO DUE TIPI DI CONVERSIONE:
        // - IMPLICITA: si utilizza il termine COERCION. 
        //   Essa e' svolta in maniera AUTOMATICA dal compilatore.
        // - ESPLICITA: viene chiamato CASTING

        // In Java, ci sono due tipi di SEQUENZA casting:
        // - AMPLIAMENTO del casting (WIDENING Casting): conversione di un tipo più 
        //   piccolo in un tipo più grande. (IMPLICITO)
        //   byte -> short -> char -> int -> long -> float -> double
        // - Casting RESTRINGENTE (MANUALMENTE): conversione di un tipo più grande
        //   in un tipo di dimensioni più piccole.
        //   double -> float -> long -> int -> char -> short -> byte
        
        int myInt = 10;
        double myDouble = myInt; //casting 'automatico': int to double - WIDENING

        System.out.println(myInt); //output 10
        System.out.println(myDouble); //output 10.0

        double myD = 9.78d;
        int myI = (int) myD; // casting manuale: double to int - RESTRINGENTE

        System.out.println(myD); // Outputs 9.78
        System.out.println(myI); // Outputs 9

        float myF = 112.8f;
        int myI2 = (int) myF; // casting manuale: double to int - RESTRINGENTE

        System.out.println(myF); // Outputs 112.8f
        System.out.println(myI2); // Outputs 112
    }
}
