import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    static int id;
    LocalDate date;
    List<Plat> plats;
    Client client;
    Serveur serveur;


    public Commande() {
        this.date = LocalDate.now();
        id++;
        this.plats = new ArrayList<>();
    }


}
