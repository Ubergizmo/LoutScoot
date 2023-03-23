package Louscoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Catalogue monCatalogue = new Catalogue();
        header(monCatalogue);
        monCatalogue.ajouterScooter(createScooter(0, "bmw", 50, 500, true, true));
        /*monCatalogue.printCatag();*/
    }
    public static void header(Catalogue c){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========Louscoot=========");
        System.out.println("1- Louer un scooter");
        System.out.println("2- Retourner un scooter");
        System.out.println("3- Etat d'un scooter");
        System.out.println("4- Affichage de l'état du parc de scooters");
        System.out.println("5- Saisie du parc des scooters");
        System.out.println("6- Quitter le programme");
        int choix = scanner.nextInt();
        switch (choix){
            case  (1):System.out.println("entrer un id pour louer un scoot");
            c.LouerScooter();
            break;
            case  (2):System.out.println("entrer un id pour rendre un scoot");
            break;
            case  (3):System.out.println("entrer un id pour l'etat de vehicule");
            break;
        }

    }
    public static Scooter createScooter(int a, String b , int c , int d , boolean e, boolean f){
        return new Scooter(a, b, c, d, e, f);
    }

}
