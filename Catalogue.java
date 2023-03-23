package Louscoot;

import java.util.Scanner;

public class Catalogue {
    Scooter[] catalogue = new Scooter[4];

    public void ajouterScooter(Scooter s) {
        // This method adds a scooter to the catalog.
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                catalogue[i] = s;
                break;
            }
        }
    }
    public boolean checkId(int a){
        for(int i = 0; i<catalogue.length;i++){
            if(a==catalogue[i].getId()){
                return true;
            }
        }
        return false;
    }
    public Location addLoc(Client a , Scooter b , String c, String d){
        return new Location(a, b, c, d);
    }
    public Client addClient(int a, String b , String c){
        return new Client(a, b, c);
    }
    public void printCatag(){
        for (int i = 0 ;i<catalogue.length;i++){
            System.out.println(catalogue[i]);
        }
    }
    public Location reservation(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Votre nom?");
        String nom = scanner.nextLine();
        System.out.println("Votre prenom?");
        String prenom = scanner.nextLine();
        System.out.println("Votre télephone?");
        int numero = scanner.nextInt();
        Client x = addClient(numero, nom, prenom);
        System.out.println("Client enregistré!");
        System.out.println("Date de réservation?");
        String dateDebut = scanner.nextLine();
        System.out.println("Fin de réservation?");
        String dateFin = scanner.nextLine();
        return  addLoc(x, catalogue[id], dateDebut, dateFin );
    }
    public void LouerScooter() {
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
