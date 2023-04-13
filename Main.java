package Model.model;

import java.io.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main  {

    public static void main(String[] args) throws IOException {
        String dataPath = "D:\\L2\\Poo\\Model\\model\\data.csv";
        String calendrierPath = "D:\\L2\\Poo\\Model\\model\\calendrier.csv";
        Parc parc = new Parc();
        Entreprise  entreprise= new Entreprise("LouScoot", "32 Chemins des Mimosas");
        String dataLine = "";
        String calendrierLine = "";
        try {
            BufferedReader dataReader = new BufferedReader(new FileReader(dataPath));
            BufferedReader calendrierReader = new BufferedReader(new FileReader(calendrierPath));
            int i = 0;
            while((dataLine = dataReader.readLine()) != null && (calendrierLine = calendrierReader.readLine()) !=null && i < 4) {
                String[] dataValues = dataLine.split(",");
                String model = dataValues[0];
                int rentPrice = Integer.parseInt(dataValues[1]);
                int kilometre = Integer.parseInt(dataValues[2]);
                boolean disponible = Boolean.parseBoolean(dataValues[3]);
                boolean etatVehicule = Boolean.parseBoolean(dataValues[4]);
                Scooter scooter = new Scooter(model, rentPrice, kilometre, disponible, etatVehicule);
                parc.catalogue[i] = scooter;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String[] calendrierValues = calendrierLine.split(",");
                LocalDate dateD = LocalDate.parse(calendrierValues[0], formatter);
                LocalDate dateF = LocalDate.parse(calendrierValues[1], formatter);
                Location location = new Location(dateD,dateF);
                parc.calendrier[i] = location;
                i++;
            }
            System.out.println("Bienvenue sur "+entreprise.nom);
            System.out.println(entreprise.adresse);
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

                    parc.LouerScooter();
                    break;
                case 2:
                    parc.retourScooter();
                    break;
                case 3:
                    parc.etatScooter();
                    break;
                case 4:
                    parc.afficherParc();
                    break;
                case 5:
                    parc.saisirParcScooters();
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


    public static void saisirParcScooters() {
        // Logique pour saisir le parc des scooters
        System.out.println("Option 5 sélectionnée : saisir le parc des scooters");
    }



}