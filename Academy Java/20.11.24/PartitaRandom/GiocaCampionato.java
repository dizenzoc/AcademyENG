public class GiocaCampionato {
    public static void main(String[] args) {
        
        Campionato campionato = new Campionato("Campionato di Calcio");
        
        campionato.giocaCampionato();
        campionato.mostraClassifica();
        campionato.mostraVincitore();
    }
}