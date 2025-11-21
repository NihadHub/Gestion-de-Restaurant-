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

    public void passerUneCommande(Client client, Serveur serveur, String nomDePlat) {

        for (Plat plat : plats) {
            if (Objects.equals(plat.nomDePlat, nomDePlat)) {
                command.serveur = serveur;
                command.client = client;
                command.plats.add(plat);
                client.commandes.add(command);
                serveur.commandes.add(command);
                commandeList.add(command);
                return;
            }
        }

        System.out.println("Nous somme désoler ! Cette plat n'existé pas.");

    }
    public void afficherLesDetailDeCommand() {
        double prixTotal = 0;
        for (Commande commande : commandeList) {
            System.out.println("L'id de commande : " + Commande.id);
            System.out.println("L'id de client : " + commande.client.id);
            System.out.println("L'id de serveur : " + commande.serveur.id);
            System.out.println("La date de commande : " + commande.date.toString());
            for (Plat plat : commande.plats) {
                System.out.println("L'id de plat : " + plat.id);
                System.out.println("Le nom de plat : " + plat.nomDePlat);
                System.out.println("Le prix de plat : " + plat.prix);
                prixTotal += plat.prix;
            }
        }
        calculerLeTotalDeLaCommande(prixTotal);
    }
    public void calculerLeTotalDeLaCommande(double prixTotal) {
        System.out.println("--------- Le prix total de votre commande est : " + prixTotal);
    }
}
