public class Main {
    public static void main(String[] args) {

        //gestione dell'eccezione con try-catch
        try{
            int num[] = {1,2,3,4};
            System.out.println(num[12]);
        } catch (Exception e){
            System.out.println("Qualcosa e' andato storto");
        } finally {
            System.out.println("Il try catch e' finito!!");
        }

        //utilizzo del throw per generare un'eccezione
        int age = 17;
        if(age < 18){
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        }
        else{
            System.out.println("You are old enough");
        }
    }
}