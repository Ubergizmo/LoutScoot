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
            else {System.out.println("Scooter disponible");}
        }
    }
}
