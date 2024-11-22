public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Fede");
        Persona persona2 = new Persona("Mario");

        persona1.saluta();
        persona2.saluta("Mario");

        Pirata pirata = new Pirata("Jack Sparrow");
        pirata.saluta();
        pirata.saluta("Jack Sparrow");
    }
}
