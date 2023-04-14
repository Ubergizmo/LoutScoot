package Model.model;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Parc {

    Scooter[] catalogue= new Scooter[4];
    Location[] calendrier = new Location[4];
    public Client addClient(String b, String c, String e) {
        return new Client(b, c, e);
    }

    public boolean checkId(int a) {
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] != null && a == catalogue[i].getId()) {
                return true;
            }
        }
        return false;
    }
    public boolean checkNumero(String e) {
        // Vérifie si le numéro est composé uniquement de chiffres et de tirets
        if (!e.matches("0\\d{9}")) {
            System.out.println("Le numéro est invalide.");
            return false;
        }
        if (!e.startsWith("0")) {
            System.out.println("Le numéro de téléphone doit commencer par le numéro 0");
            return false;
        }
        System.out.println("Le numéro est valide.");
        return true;
    }

    public void afficherParc(){
        System.out.println("|=========Affichage de l'état du parc de scooters=========|");
    for(int i = 0; i<this.catalogue.length;i++){
        System.out.println(this.catalogue[i].getId()+"-"+this.catalogue[i].getModel()+" : "+this.catalogue[i].getRentPrice()
        +"€, "+this.catalogue[i].getKilometre()+"km, "+this.catalogue[i].printEtatParc());
    }
    }
    public Location reservation(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Votre nom?");
        String nom = scanner.nextLine();
        System.out.println("Votre prenom?");
        String prenom = scanner.nextLine();
        System.out.println("Votre télephone?");
        String numero = scanner.nextLine();
        while (!checkNumero(numero)){
            numero = scanner.nextLine();
        }
        Client x = addClient(nom, prenom, numero);
        System.out.println("Client enregistré!");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Date de réservation");
        System.out.println("Date de début de réservation (format AAAA-MM-JJ) ?");
        String dateDebutString = scanner.nextLine();
        LocalDate dateD = LocalDate.parse(dateDebutString, formatter);
        System.out.println("Date de fin de réservation (format AAAA-MM-JJ) ?");
        String dateFinString = scanner.nextLine();
        LocalDate dateF = LocalDate.parse(dateFinString, formatter);
        while (!this.calendrier[id-1].dateAfter(dateF, dateD)){
            System.out.println("Date de début de réservation (format AAAA-MM-JJ) ?");
            dateDebutString = scanner.nextLine();
            dateD = LocalDate.parse(dateDebutString, formatter);
            System.out.println("Date de fin de réservation (format AAAA-MM-JJ) ?");
            dateFinString = scanner.nextLine();
            dateF = LocalDate.parse(dateFinString, formatter);
        }
        Location location = new Location(dateD, dateF);
        System.out.println("Location créée!");
        this.calendrier[id-1] = location;
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
        System.out.println("Le véhicule est en bon état ? 0 pour Non/1 pour Oui");
        int response = scanner.nextInt();
        if(response==1){
            this.catalogue[id-1].setEtatT();
        }
        if(response==0){
            this.catalogue[id-1].setEtatF();
        }
        this.calendrier[id-1].remiseZero();

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
                    " : "+this.catalogue[id-1].getKilometre()+"km, " + this.catalogue[id-1].printDisponibilite());
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
                System.out.println("Scooter actuellement en location");
                System.out.println("Scooter disponible à partir du "+ this.calendrier[id-1].getDateFin());
                System.out.println("Voulez vous toujours le louer? 0-Non/1-Oui");
                int choix = scanner.nextInt();
                if(choix==1){
                    reservation(id);
                }
                else {
                    this.save();
                }
            }
            else if (!catalogue[id-1].getEtatVehicule()) {
                System.out.println("Scooter indisponible à la location");
            } else {
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
        String dataPath = "D:\\L2\\Poo\\Model\\model\\data.csv";
        String calendrierPath = "D:\\L2\\Poo\\Model\\model\\calendrier.csv";
        try {
            FileWriter dataWriter = new FileWriter(dataPath);
            BufferedWriter calendrierWriter = new BufferedWriter(new FileWriter(calendrierPath));
            for (int i = 0; i < this.catalogue.length; i++) {
                dataWriter.write(this.catalogue[i].getModel() + ",");
                dataWriter.write(this.catalogue[i].getRentPrice() + ",");
                dataWriter.write(this.catalogue[i].getKilometre() + ",");
                dataWriter.write(this.catalogue[i].getDisponibilite() + ",");
                dataWriter.write(this.catalogue[i].getEtatVehicule() + "\n");
            }
            for (int i = 0;i<this.calendrier.length;i++) {
                calendrierWriter.write(this.calendrier[i].getDateDebut().toString()+",");
                calendrierWriter.write(this.calendrier[i].getDateFin().toString()+ "\n");
            }
            calendrierWriter.close();

            dataWriter.close();

            System.out.println("Sauvegarde réussie");
        }catch (FileNotFoundException e){ System.out.println("Sauvegarde échoué.");}
    }

}