package Model.model;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Parc {

    Scooter[] catalogue= new Scooter[4];

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

    public void afficherParc(){
        System.out.println("|=========Affichage de l'état du parc de scooters=========|");
    for(int i = 0; i<this.catalogue.length;i++){
        System.out.println(this.catalogue[i].getId()+"-"+this.catalogue[i].getModel()+" : "+this.catalogue[i].getRentPrice()
        +"€, "+this.catalogue[i].getKilometre()+"km, " + this.catalogue[i].printDisponibilite() +", "+this.catalogue[i].printEtat());
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
        Client x = addClient(nom, prenom);
        System.out.println("Client enregistré!");
        System.out.println("Date de réservation");
        scanner.nextLine(); // pour consommer le caractère '\n' laissé par nextInt()
        System.out.println("Date de début de réservation (format JJ/MM/AAAA) ?");
        String dateDebutString = scanner.nextLine();

        Date dateDebut=null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateDebut = dateFormat.parse(dateDebutString);
        } catch (Exception e) {
            System.out.println("La date saisie n'est pas au format JJ/MM/AAAA !");
            System.exit(0);
        }

        // Saisie de la date de fin
        System.out.println("Date de fin de réservation (format JJ/MM/AAAA) ?");
        String dateFinString = scanner.nextLine();
        Date dateFin=null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFin = dateFormat.parse(dateFinString);
        } catch (Exception e) {
            System.out.println("La date saisie n'est pas au format JJ/MM/AAAA !");
        }
        Location location = new Location(dateDebut, dateFin);

        location.getDateDebut();
        location.getDateFin();
        System.out.println("Location créée!");
        catalogue[id-1].setFalse();


        return location;
    }
    public void retour(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel kilometre affiche le compteur?");
        int kilometre = scanner.nextInt();
        while (kilometre <= this.catalogue[id-1].getKilometre()){
            System.out.println("Le nombre entré doit être supérieur à l'ancienne valeur");
            System.out.println("Quel kilometre affiche le compteur?");
            kilometre = scanner.nextInt();
        }
        this.catalogue[id-1].setKilometre(kilometre) ;
    }
    public void etatScooter(){
        System.out.println("Option 3 sélectionnée : État d'un scooter");
        System.out.println("|=========Etat d'un scooter=========|");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Numéro d'identification du scooter : ");
        int id = scanner.nextInt();
        if (!checkId(id)){
            System.out.println("Scooter non existant");
        } else{
            System.out.println(this.catalogue[id-1].getId()+"-"+this.catalogue[id-1].getModel()+
                    " : "+this.catalogue[id-1].getKilometre()+"km ," + this.catalogue[id-1].printDisponibilite());
            }
        }
    public void LouerScooter() throws IOException {
        System.out.println("Option 1 sélectionnée : Louer un scooter");
        System.out.println("|=========Louer un scooter=========|");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Numéro d'identification du scooter : ");
        int id = scanner.nextInt();
        if (!checkId(id)){
            System.out.println("Scooter non existant");
        } else{
            if (!catalogue[id-1].getDisponibilite()) {
                System.out.println("Scooter actuellement en location");}
            else {
                System.out.println("Scooter disponible");
                reservation(id);
                System.out.println("Reservation enregistré!");
                catalogue[id-1].setFalse();
            }
        }
        this.save();
    }
    public void retourScooter() throws IOException {
        System.out.println("Option 2 sélectionnée : Retourner un scooter");
        System.out.println("|=========Retourner un scooter=========|");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Numéro d'identification du scooter : ");
        int id = scanner.nextInt();
        if (!checkId(id)){
            System.out.println("Scooter non existant");
        } else{
            if (catalogue[id-1].getDisponibilite()) {
                System.out.println("Le scooter n'est pas en location");}
            else {
                System.out.println("Scooter trouvé!");
                retour(id);
                catalogue[id-1].setTrue();
                System.out.println("Retour enregistré!");
            }
        }
        this.save();
    }
    public void saisirParcScooters() {
        int nbTotalScooters = catalogue.length;
        int nbScootersLocation = 0;
        int nbScootersDisponibles = 0;
        int totalKilometrage = 0;

        System.out.println("|===========Etat Résumé==========|");
        for(int i = 0; i<catalogue.length; i++){
            totalKilometrage += catalogue[i].getKilometre();
            if (catalogue[i].getDisponibilite()) {
                nbScootersDisponibles++;
                System.out.println("Scooter " + catalogue[i].getId() + " disponible");
            } else {
                nbScootersLocation++;
                System.out.println("Scooter " + catalogue[i].getId() + " en location");
            }
        }
        System.out.println("|================================|");
        System.out.println("Nombre total de scooters: " + nbTotalScooters);
        System.out.println("Nombre de scooters en location: " + nbScootersLocation);
        System.out.println("Nombre de scooters disponibles: " + nbScootersDisponibles);
        System.out.println("Kilométrage moyen: " + (double) totalKilometrage / nbTotalScooters);
    }
    public void save() throws IOException {
        String path = "D:\\L2\\Poo\\Model\\model\\data.csv";
        String line = "";
        try {
            FileWriter writer = new FileWriter(path);

            for (int i = 0; i < this.catalogue.length; i++) {
                writer.write(this.catalogue[i].getModel() + ",");
                writer.write(this.catalogue[i].getRentPrice() + ",");
                writer.write(this.catalogue[i].getKilometre() + ",");
                writer.write(this.catalogue[i].getDisponibilite() + ",");
                writer.write(this.catalogue[i].getEtatVehicule() + "\n");
            }

            writer.close();

            System.out.println("Sauvegarde réussie");
        }catch (FileNotFoundException e){ System.out.println("Sauvegarde échoué.");}
    }


}