package Louscoot;

import java.util.Scanner;

public class Catalogue {
    Scooter[] catalogue = new Scooter[10];

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
    public void LouerScooter() {
        System.out.println("=========Louer un scooter=========");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Numéro d'identification du scooter : ");
        int id = scanner.nextInt();
        if (!checkId(id)){
            System.out.println("Scooter non existant");
        } else{
            if (!catalogue[id].getDisponibilite()) {
                System.out.println("Scooter non indisponible");}
            else {
                System.out.println("Scooter disponible");
                System.out.println("Votre nom?");
                String nom = scanner.nextLine();
                System.out.println("Votre prenom?");
                String prenom = scanner.nextLine();
                System.out.println("Votre télephone?");
                int numero = scanner.nextInt();

            }
        }
    }
}
