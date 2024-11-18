public class EsStr {
    public static void main(String[] args){
        //esempio di length
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("The length of the txt string is: " + txt.length());

        String txt2 = "Hello World";
        System.out.println(txt2.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(txt2.toLowerCase());   // Outputs "hello world"

        String txt3 = "Please locate where 'locate' occurs!";
        System.out.println(txt3.indexOf("locate")); // Outputs 7

        // DUE MODI PER CONCATENARE DUE STRINGHE
        String firstName = "John";
        String lastName = "Doe";
        System.out.println(firstName + " " + lastName);

        String firstName1 = "John ";
        String lastName1 = "Doe";
        System.out.println(firstName1.concat(lastName1));
        //PREFERIBILE CONCAT PER LEGGIBILITA' E LEGGERISSIMA OTTIMIZZAZIONE

        String x = "10";
        String y = "20";
        String z = x + y;  // z will be 1020 (a String)
        System.out.println(z);

        //Se aggiungi un numero e una stringa, il risultato sarà una concatenazione di stringhe:
        String a = "10";
        int b = 20;
        String c = a + b;  // z will be 1020 (a String)
        System.out.println(c);
    }
}
