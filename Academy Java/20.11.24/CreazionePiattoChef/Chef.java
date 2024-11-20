package CreazionePiattoChef;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Chef {
    public String nome;
    public String tipo;
    public List<String> ingredienti;

    public Chef(String nome, String tipo, List<String> ingredienti) {
        this.nome = nome;
        this.tipo = tipo;
        this.ingredienti = ingredienti;
    }

    public List<String> creaPiatti() {
        List<String> piatti = new ArrayList<>();
        switch (tipo) {
            case "Italiano":
                for (String ingrediente : ingredienti) {
                    switch (ingrediente) {
                        case "pasta":
                            piatti.add("Spaghetti alla Carbonara");
                            piatti.add("Pasta al Pomodoro");
                            break;
                        case "riso":
                            piatti.add("Risotto ai Funghi");
                            piatti.add("Arancini");
                            break;
                        default:
                            piatti.add("Insalata Caprese");
                            break;
                    }
                }
                break;
            case "Giapponese":
                for (String ingrediente : ingredienti) {
                    switch (ingrediente) {
                        case "riso":
                            piatti.add("Sushi");
                            piatti.add("Onigiri");
                            break;
                        case "noodles":
                            piatti.add("Ramen");
                            piatti.add("Udon");
                            break;
                        default:
                            piatti.add("Tempura");
                            break;
                    }
                }
                break;
            case "Messicano":
                for (String ingrediente : ingredienti) {
                    switch (ingrediente) {
                        case "tortilla":
                            piatti.add("Tacos");
                            piatti.add("Quesadilla");
                            break;
                        case "riso":
                            piatti.add("Burrito");
                            piatti.add("Paella");
                            break;
                        default:
                            piatti.add("Guacamole");
                            break;
                    }
                }
                break;
            case "Indiano":
                for (String ingrediente : ingredienti) {
                    switch (ingrediente) {
                        case "riso":
                            piatti.add("Biryani");
                            piatti.add("Pulao");
                            break;
                        case "paneer":
                            piatti.add("Paneer Butter Masala");
                            piatti.add("Palak Paneer");
                            break;
                        default:
                            piatti.add("Samosa");
                            break;
                    }
                }
                break;
            case "Francese":
                for (String ingrediente : ingredienti) {
                    switch (ingrediente) {
                        case "pane":
                            piatti.add("Croque Monsieur");
                            piatti.add("Baguette");
                            break;
                        case "patate":
                            piatti.add("Gratin Dauphinois");
                            piatti.add("Pommes Frites");
                            break;
                        default:
                            piatti.add("Ratatouille");
                            break;
                    }
                }
                break;
            default:
                piatti.add("Piatto non disponibile");
                break;
        }
        return piatti;
    }
}