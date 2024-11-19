public class EsempiCicli {
    public static void main(String[] args){
        //utilizzo while
        
        //while matematico
        System.out.println("-----WHILE MATEMATICO-----");
        int i=1;
        while(i <= 10){
            System.out.println(i++); //stampa i numeri da 1 a 10

        }
       
        System.out.println("-----WHILE BOOLEANO CON RESET VAR. BOOLEAN-----");
        //while booleano con cambio val. boolean
        boolean check = true;
        while(check){
            System.out.println("Questa e' la stampa nr. " + i++);
            if(i == 21)
                check = false; // cambio var. boolean per interropere il ciclo
        }

        System.out.println("-----WHILE BOOLEANO CON BREAK-----");
        //while booleano con break
        check = true; // reset variabile check
        while(check){
            System.out.println("Questa e' la stampa nr. " + i++);
            if(i == 31)
                break; //interrompe il ciclo
        }

        //esempio do-while
        System.out.println("-----DO-WHILE-----");
        //non inizializzo il contatore i in quanto riutilizzo quello precedente
        do{
            System.out.println(i++);
        }while(i <= 40);

        //utilizzo for
        System.out.println("-----FOR-----");
        //ricomincio la numerazione
        for (int j = 1; j < 11; j++) {
            System.out.println(j); //stampo i numeri da 1 a 10
        }
    }
}
