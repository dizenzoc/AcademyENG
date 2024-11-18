import java.util.Scanner; // import Scanner class
public class StruttureCondizionali {
    public static void main(String[] args){
        
        System.out.print("Inserisci l'ora attuale: ");
        Scanner scInt = new Scanner(System.in);
        int time = scInt.nextInt();
        //Struttura condizionale if, else and else if
        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        int day = 4;
        switch (day) {
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

        scInt.close();
    }
}
