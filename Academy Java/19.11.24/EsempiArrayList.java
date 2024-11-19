import java.util.ArrayList;
import java.util.Arrays;
public class EsempiArrayList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>(); //dichiaro arraylist
        
        // possiamo aggiungere elementi all'arraylist con metodo add()
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        //stampo l'arraylist
        System.out.print("ArrayList: ");
        System.out.println(cars);
        
        cars.set(0, "Opel"); //inserisco opel in posizione 0 con metodo set()
        System.out.println("\n"+cars.get(0)); //stampo a video la car in posizione 0

        //possiamo calcolare dimensione di un arraylist con medoto size()
        System.out.println("\nLa dimensione dell'array list e\': " + cars.size());
        
        //possiamo rimuovere un elemento di un arraylist con medoto remove()
        cars.remove(0);
        System.out.println("\nOra la dimensione dell'array list e\': " + cars.size());

        //possiamo rimuovere tutti gli elementi di un arraylist con medoto clear()
        cars.clear();
        System.out.println("\nOra la dimensione dell'array list e\': " + cars.size());

        //CONVERSIONE ARRAY IN ARRAY_LIST - Metodo: Arrays.asList()
        Integer interi[] = { 1 , 2 , 3 , 4 , 5 , 6 };  
        System.out.println("\nArray:" +Arrays.toString(interi));  
        ArrayList<Integer> arrayList =  new  ArrayList<Integer>(Arrays.asList(interi));  
        arrayList.add(7);  
        interi = arrayList.toArray(interi);  
        System.out.println("Array dopo aggiunta: " +Arrays.toString(interi)); 
  }
}
