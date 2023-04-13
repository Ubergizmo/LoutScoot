package Model.model;
import java.time.LocalDate;
import java.util.*;


public class Location {

    public LocalDate dateDebut;
    private LocalDate dateFin;
    private boolean dateLimite;
    private Client client;



    public Location(LocalDate c, LocalDate d){
        dateDebut = c ;
        dateFin = d;

    }
    public LocalDate getDateDebut(){
        return dateDebut;
    }
    public LocalDate getDateFin(){
        return dateFin;
    }
}