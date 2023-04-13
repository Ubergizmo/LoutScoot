package Model.model;
public class Client {

    private String nom;
    private String prenom;
    private String numero;
    private Entreprise entreprise;

    public Client( String c , String d, String e){

        this.nom = c;
        this.prenom = d;
        this.numero = e;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getNumero(){
        return this.numero;
    }
}