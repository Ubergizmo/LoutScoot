package Louscoot;

public class Location {
    private Client client;
    private Scooter scooter;
    private String dateDebut;
    private String dateFin;
    private boolean dateLimite;
    private int n;

    public Location(Client a , Scooter b, String c, String d){
        client = a;
        scooter = b;
        dateDebut = c ;
        dateFin = d;

    }
    public Client getClient(){
        return client;
    }
    public Scooter getScooter(){
        return scooter;
    }
    public String getDateDebut(){
        return dateDebut;
    }
    public String getDateFin(){
        return dateFin;
    }
}
