package CreazionePiattoChef;

import java.util.List;
import java.util.ArrayList;

public class TestChef {
    public static void main(String[] args) {
        // dichiaro gli ingredienti per nazionalita'
        ArrayList<String> ingredientiItaliani = new ArrayList<>();
        ingredientiItaliani.add("pasta");
        ingredientiItaliani.add("pomodoro");
        ingredientiItaliani.add("formaggio");

        ArrayList<String> ingredientiGiapponesi = new ArrayList<>();
        ingredientiGiapponesi.add("riso");
        ingredientiGiapponesi.add("pesce");
        ingredientiGiapponesi.add("alghe");

        ArrayList<String> ingredientiFrancesi = new ArrayList<>();
        ingredientiFrancesi.add("pane");
        ingredientiFrancesi.add("formaggio");
        ingredientiFrancesi.add("patate");

        // creo 3 chef
        Chef chef1 = new Chef("Mario", "Italiano", ingredientiItaliani);
        Chef chef2 = new Chef("Sakura", "Giapponese", ingredientiGiapponesi);
        Chef chef3 = new Chef("Pierre", "Francese", ingredientiFrancesi);

        // stampo piatti creati dai 3 chef
        System.out.println(chef1.nome + " ha creato: " + chef1.creaPiatti());
        System.out.println(chef2.nome + " ha creato: " + chef2.creaPiatti());
        System.out.println(chef3.nome + " ha creato: " + chef3.creaPiatti());
    }
}
