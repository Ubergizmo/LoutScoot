package Model.model;
import java.net.http.HttpClient;
import java.util.*;


public class Location {

    public Date dateDebut;
    private Date dateFin;
    private boolean dateLimite;
    private Client client;



    public Location( Date c, Date d){
        dateDebut = c ;
        dateFin = d;

    }
    public Date getDateDebut(){
        return dateDebut;
    }
    public Date getDateFin(){
        return dateFin;
    }

    public Date dateD(Date dateDebut){
        return dateDebut;
    }
    public Date dateF(Date dateFin){
        return dateFin;
    }

}