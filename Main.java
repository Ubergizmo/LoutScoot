package Model.model;

import java.io.*;

import java.util.*;


public class Main  {

    public static void main(String[] args) throws IOException {
        String path = "D:\\L2\\Poo\\Model\\model\\datas.txt";
        Scooter [] parc = new Scooter[3];
        Parc test = new Parc(3);
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine() && i < 3) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String model = data[0];
                int rentPrice = Integer.parseInt(data[1]);
                int kilometre = Integer.parseInt(data[2]);
                boolean disponible = Boolean.parseBoolean(data[3]);
                boolean etatVehicule = Boolean.parseBoolean(data[4]);

                Scooter scooter = new Scooter( model, rentPrice, kilometre, disponible, etatVehicule);
                parc[i] = scooter;
                i++;
                System.out.println("Fichier modifié avec succès.");
            }

            scanner.close();
            //String newData = data.replaceAll("Caleb", "Kyky");
            //System.out.println(newData);
            //PrintWriter writer = new PrintWriter(file);
            //writer.print(newData);
            //writer.close();

            System.out.println("Fichier modifié avec succès.");
        }catch (Exception e){ System.out.println(e);}
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
                    test.LouerScooter1();
                    break;
                case 2:
                    retourScooter();
                    break;
                case 3:
                    etatScooter();
                    break;
                case 4:
                    afficherParc(parc);
                    break;
                case 5:
                    saisirParcScooters();
                    break;
                case 6:
                    isRunning = false;
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

    public static void afficherParc(Scooter [] e){
        for(int i = 0; i<e.length;i++){
            System.out.println(e[i].getId()+","+e[i].getModel()+","+e[i].getRentPrice()
                    +","+e[i].getKilometre()+","+e[i].getDisponibilite());
        }
    }

    public static void saisirParcScooters() {
        // Logique pour saisir le parc des scooters
        System.out.println("Option 5 sélectionnée : saisir le parc des scooters");
    }

    /**
     * 
     */
    public void header() {
        // TODO implement here
    }

    /**
     * 
     */
    public void createScooter() {
        // TODO implement here
    }

}