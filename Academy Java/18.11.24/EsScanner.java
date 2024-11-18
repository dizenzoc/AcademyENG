import java.util.Scanner; // import Scanner class
public class EsScanner {
    public static void main(String[] args){
        
        System.out.println("--------STRING USER INPUT--------");
        Scanner myObj = new Scanner(System.in); // create a Scanner Object
        System.out.print("Enter username: ");
        String username = myObj.nextLine(); // read user input
        System.out.println("Username is: " + username); //output user input
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        System.out.println("--------WIDENING CAST (AUTOMATICO)--------");
        Scanner myNum = new Scanner(System.in); // create a Scanner for integer number
        System.out.print("Enter a integer number: ");
        int numInt = myNum.nextInt(); // read user input
        float numFloat = numInt; //casting 'automatico': int to double - WIDENING
        System.out.println("Inter number is: " + numInt); //output integer user input
        System.out.println("Float number is: " + numFloat); //output float of integer user input
        System.out.println("----------------------------------------------------------------\n");

        System.out.println("--------CAST RESTRINGENTE (MANUALE)--------");
        Scanner myNumSc = new Scanner(System.in); // create a Scanner for float number
        System.out.print("Enter a float number: ");
        float numF = myNumSc.nextFloat(); // read user input
        int numI = (int) numF; // casting manuale: float to int - RESTRINGENTE
        System.out.println("Float number is: " + numF); //output float user input
        System.out.println("Integer number is: " + numI); //output integer of float user input
        System.out.println("----------------------------------------------------------------\n");

        myObj.close();
        myNum.close();
        myNumSc.close();
    }
}
