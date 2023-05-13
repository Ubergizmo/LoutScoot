package Model.model;

import java.io.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main  {

    public static void main(String[] args) throws IOException {
        //dataPath et calendrierPath contiennent le repertoires de nos fichiers csv
        String dataPath = "D:\\L2\\Poo\\Model\\model\\data.csv";
        String calendrierPath = "D:\\L2\\Poo\\Model\\model\\calendrier.csv";
        String clientPath = "D:\\L2\\Poo\\Model\\model\\clients.csv";
        Parc parc = new Parc();
        Entreprise entreprise = new Entreprise("LouScoot", "32 Chemins des Mimosas");
        System.out.println(entreprise.printEnts(entreprise.nom, entreprise.adresse));
        String dataLine = "";
        String calendrierLine = "";
        String clientLine = "";
        try {
            //BufferedReader est un type qui permet de lire notre ficher csv
            BufferedReader dataReader = new BufferedReader(new FileReader(dataPath));
            BufferedReader calendrierReader = new BufferedReader(new FileReader(calendrierPath));
            BufferedReader clientReader = new BufferedReader(new FileReader(clientPath));
            int i = 0;
            //Cet boucle permet de lire les lignes une a une et de les enregistré dans des tableaux
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
            while((clientLine = clientReader.readLine()) != null) {
                String[] dataValues = clientLine.split(",");
                    String nom = dataValues[0];
                    String prenom = dataValues[1];
                    String numero = dataValues[2];
                    Client client = new Client(nom, prenom, numero);
                    int n = Integer.parseInt(dataValues[3]);
                    Registre registre = new Registre(client, n);
                    parc.registres.add(registre) ;
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
                case 1 -> parc.LouerScooter();
                case 2 -> parc.retourScooter();
                case 3 -> parc.etatScooter();
                case 4 -> parc.afficherParc();
                case 5 -> parc.saisirParcScooters();
                case 6 -> {
                    isRunning = false;
                    parc.save();
                    System.out.println("Programme terminé.");
                }
                default -> System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}