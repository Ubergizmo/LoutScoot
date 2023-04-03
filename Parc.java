package Model.model;
import java.util.*;

/**
 *
 */
public class Parc {

    private int capacité;
    Scooter[] catalogue;

public Parc(int n ){
    Scooter[] catalogue = new Scooter[capacité];

}
    public Client addClient(String b, String c) {
        return new Client(b, c);
    }

    public boolean checkId(int a) {
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] != null && a == catalogue[i].getId()) {
                return true;
            }
        }
        return false;
    }

    /*public void afficherParc(){
    for(int i = 0; i<catalogue.length;i++){
        System.out.println(catalogue[i].getId()+","+catalogue[i].getModel()+","+catalogue[i].getRentPrice()
        +","+catalogue[i].getKilometre()+","+catalogue[i].getDisponibilite());
    }
    }*/

    public Location reservation(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Votre nom?");
        String nom = scanner.nextLine();
        System.out.println("Votre prenom?");
        String prenom = scanner.nextLine();
        System.out.println("Votre télephone?");
        int numero = scanner.nextInt();
        Client x = addClient(nom, prenom);
        System.out.println("Client enregistré!");
        System.out.println("Date de réservation?");
        String dateDebut = scanner.nextLine();
        System.out.println("Fin de réservation?");
        String dateFin = scanner.nextLine();
        return null;
    }

    public void LouerScooter1() {
        System.out.println("=========Louer un scooter=========");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Numéro d'identification du scooter : ");
        int id = scanner.nextInt();
        if (!checkId(id)){
            System.out.println("Scooter non existant");
        } else{
            if (!catalogue[id].getDisponibilite()) {
                System.out.println("Scooter actuellement en location");}
            else {
                System.out.println("Scooter disponible");
                reservation(id);
                System.out.println("Reservation enregistré!");
                catalogue[id].setFalse();
            }
        }
    }
}