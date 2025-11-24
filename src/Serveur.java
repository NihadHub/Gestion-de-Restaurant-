import java.util.ArrayList;
import java.util.List;

public class Serveur {

    int id;
    List<Commande> commandes;

    public Serveur(int id) {
        this.id = id;
        this.commandes = new ArrayList<>();
    }
}
