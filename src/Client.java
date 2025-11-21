import java.util.ArrayList;
import java.util.List;

public class Client {
    int id;
    List<Commande> commandes;

    public Client(int id) {
        this.id = id;
        this.commandes = new ArrayList<>();
    }
}

