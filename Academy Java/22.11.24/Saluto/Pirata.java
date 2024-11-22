public class Pirata extends Persona {
    
    public Pirata (String nome){
        super(nome);
    }

    @Override
    public void saluta(){
        System.out.println("Oiiiilaa! Sono un pirata!");
    }
    
    @Override
    public void saluta(String nome){
        System.out.println("Oiiiilaa! Sono il pirata " + nome + "!");
    }
}
