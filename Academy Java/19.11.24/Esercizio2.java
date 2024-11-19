public class Esercizio2 {
    /* Scrivi un programma che calcoli e stampi il giorno della settimana corrispondente
        a numeri da 1 a 7. Usa un ciclo for e un switch per abbinare ogni numero al nome del giorno.
        Usa un ciclo for per iterare dal numero 1 al numero 7.
        Per ogni numero, usa un switch per determinare il giorno della settimana
        (ad esempio, 1 = Lunedì, 2 = Martedì, ecc.).
        Stampa il giorno della settimana corrispondente. */

    public static void main(String[] args){
        System.out.println("I giorni della settimana sono:");
        
        for (int i = 1; i < 8; i++) { //utilizzo un for per iterare da 1 a 7 (giorni della settimana)
            switch (i) { //uso uno switch per determinare il giorno corretto
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
                    break;
                default:
                    break;
            }
        }
    }
}
