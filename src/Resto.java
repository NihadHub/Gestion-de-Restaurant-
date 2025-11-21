import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Resto {
    List<Commande> commandeList;
    Scanner input;
    //int choix = 0;

    public Resto() {
        this.commandeList = new ArrayList<>();
        input = new Scanner(System.in);
    }

    Commande command = new Commande();

    Plat[] plats = {  // resto
            new Plat(1, "Tajin", 100),
            new Plat(2, "Sandwich", 50),
            new Plat(3, "Koskous", 160),
            new Plat(4, "Soup", 10),
            new PlatSpecial(4, "Pizza", 100),
    };

    public void passerUneCommande(Client client, Serveur serveur, String nomDePlat) {

        for (Plat plat : plats) {
            if (Objects.equals(plat.nomDePlat, nomDePlat)) {
                // Passer la commande au serveur
                command.serveur = serveur;
                // Le client qu'il a demandé la plat
                command.client = client;
                // Ajouter la plat.
                command.plats.add(plat);
                // Ajouter la commande entier dans la commande list de client
                client.commandes.add(command);
                // Ajouter la commande entier dans la commande list de client
                serveur.commandes.add(command);
                commandeList.add(command);
                return;
            }
        }

        System.out.println("Nous somme désoler ! Cette plat n'existé pas.");

    } // Client

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
    } // Command

    public void calculerLeTotalDeLaCommande(double prixTotal) {
        System.out.println("--------- Le prix total de votre commande est : " + prixTotal);
    } // Command


    public void afficherLeMenu() {

        System.out.println("--------------Le menu des plats-------------- : ");
        for (int i = 1; i <= plats.length; i++) {
            System.out.println(i + " - " + plats[i - 1].nomDePlat + " = " + plats[i - 1].prix);
        }
        System.out.println("------ Passer votre Commande --------");
        System.out.println("Choisir la plat preferer <Ecrire le nom de plat> : ");
        String lePlatChoisir = input.next();
        System.out.println("Entrer votre ID : ");
        int clientId = input.nextInt();
        System.out.println("Entrer l'ID de serveur pour servire votre plat : ");
        int serveurId = input.nextInt();
        if(serveurId > 10 && serveurId <= 15){
            ServeurVIP.serviceVIP();
        }

        passerUneCommande(new Client(clientId), new Serveur(serveurId), lePlatChoisir);

        System.out.println("<Si vous voulez choisir une autre plat Taper(yes) si non Taper(no) >");
        String autreChoix = input.next();
        uneAutrePlat(autreChoix);

        System.out.println("2- Afficher votre details de votre commande et le prix total : ");
        System.out.println("0- Quitter : ");
        int detailEtTotal = input.nextInt();
        menu(detailEtTotal);
    } //  resto

    public void uneAutrePlat(String autreChoix) { // Resto
        if (Objects.equals(autreChoix, "yes")) {
            afficherLeMenu();
        }
    }

    public void menu(int choix) {
        lesChoix(choix);
    } // resto

    public void start() {
        int choix;
        do {
            System.out.println("------ Menu de Resto --------");
            System.out.println("1- Afficher le Menu:");
            choix = input.nextInt();
            menu(choix);
        } while (choix == 0);
    }  // resto

    public void lesChoix(int choix) {
        switch (choix) {
            case 1:
                afficherLeMenu();
                break;
            case 2:
                afficherLesDetailDeCommand();
        }
    } // resto

}
