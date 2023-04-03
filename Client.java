package Model.model;
public class Client {

    private String nom;
    private String prenom;
    private Entreprise entreprise;

    public Client( String c , String d){

        this.nom = c;
        this.prenom = d;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
}