package Model.model;

import java.io.*;

import java.util.*;


public class Main  {

    public static void main(String[] args) throws IOException {
        String path = "D:\\L2\\Poo\\Model\\model\\data.csv";
        Parc parc = new Parc();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int i = 0;
            while((line = br.readLine()) != null && i < 3 ) {
                String[] values = line.split(";");
                String model = values[0];
                int rentPrice = Integer.parseInt(values[1]);
                int kilometre = Integer.parseInt(values[2]);
                boolean disponible = Boolean.parseBoolean(values[3]);
                boolean etatVehicule = Boolean.parseBoolean(values[4]);
                Scooter scooter = new Scooter(model, rentPrice, kilometre, disponible, etatVehicule);
                parc.catalogue[i] = scooter;
                i++;
            }
            System.out.println("Bienvenu sur LouScoot");
        }catch (FileNotFoundException e){ System.out.println("Nous présentons actuellement un soucis.");}
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Menu");
            System.out.println("1. Louer un scooter");
            System.out.println("2. Retour d'un scooter");
            System.out.println("3. État d'un scooter");
            System.out.println("4. Affichage de l'état du parc de scooters");
            System.out.println("5. Saisie du parc des scooters");
            System.out.println("6. Quitter le programme");
            System.out.print("Sélectionnez une option : ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Option 1 sélectionnée : louer un scooter");
                    parc.LouerScooter1();
                    break;
                case 2:
                    retourScooter();
                    break;
                case 3:
                    parc.etatScooter();
                    break;
                case 4:
                    parc.afficherParc();
                    break;
                case 5:
                    saisirParcScooters();
                    break;
                case 6:
                    isRunning = false;
                    parc.save();
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Option invalide.");
                    break;
            }
        }

        scanner.close();
    }

    public static void retourScooter() {
        // Logique pour retourner un scooter
        System.out.println("Option 2 sélectionnée : retourner un scooter");
    }

    public static void etatScooter() {
        // Logique pour afficher l'état d'un scooter
        System.out.println("Option 3 sélectionnée : afficher l'état d'un scooter");
    }
    public static void saisirParcScooters() {
        // Logique pour saisir le parc des scooters
        System.out.println("Option 5 sélectionnée : saisir le parc des scooters");
    }



}