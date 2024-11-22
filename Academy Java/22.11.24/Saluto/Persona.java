public class Persona {

    public String nome;

    public Persona(String nome){
        this.nome = nome;
    }

    public void saluta(){
        System.out.println("Ciaooo!");
    }

    public void saluta(String nome){
        System.out.println("Ciaooo. sono " + nome + "!");
    }
}