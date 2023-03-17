package Louscoot;

public class Client {
    private int id = 0;
    private int numero;
    private String nom;
    private String prenom;
    private Location[] locations = new Location[6];
    public Client( int b, String c , String d){
        this.id++;
        this.numero = b;
        this.nom = c;
        this.prenom = d;
    }
    public int getId(){
        return id;
    }
    public int getNumero(){
        return numero;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
}
