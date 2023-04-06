package Model.model;
import java.io.*;
import java.util.*;

/**
 *
 */
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
    for(int i = 0; i<this.catalogue.length;i++){
        System.out.println(this.catalogue[i].getId()+","+this.catalogue[i].getModel()+","+this.catalogue[i].getRentPrice()
        +","+this.catalogue[i].getKilometre()+" ," + this.catalogue[i].getDisponibilite());
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
        System.out.println("Date de réservation?");
        String dateDebut = scanner.nextLine();
        System.out.println("Fin de réservation?");
        String dateFin = scanner.nextLine();
        return null;
    }

    public void etatScooter(){
        System.out.println("|=========Etat d'un scooter=========|");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Numéro d'identification du scooter : ");
        int id = scanner.nextInt();
        if (!checkId(id)){
            System.out.println("Scooter non existant");
        } else{
            System.out.println(this.catalogue[id].getId()+","+this.catalogue[id].getModel()+
                    ","+this.catalogue[id].getKilometre()+" ," + this.catalogue[id].getDisponibilite());
            }
        }
    public void LouerScooter1()  {
        System.out.println("|=========Louer un scooter=========|");
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

    public void save() throws IOException {
        String path = "D:\\L2\\Poo\\Model\\model\\data.csv";
        String line = "";
        try {
            FileWriter writer = new FileWriter(path);

            for (int i = 0; i < this.catalogue.length; i++) {
                writer.write(this.catalogue[i].getModel() + ";");
                writer.write(this.catalogue[i].getRentPrice() + ";");
                writer.write(this.catalogue[i].getKilometre() + ";");
                writer.write(this.catalogue[i].getDisponibilite() + ";");
                writer.write(this.catalogue[i].getEtatVehicule() + "\n");
            }

            writer.close();

            System.out.println("Sauvegarde réussir");
        }catch (FileNotFoundException e){ System.out.println("Sauvegarde échoué.");}
    }
}