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
public class ServeurVIP extends Serveur{
    public ServeurVIP(int id) {
        super(id);
    }

    public void serviceVIP(){
        System.out.println("Welcome to VIP service (^^)");
    }
}
