package Model.model;
import java.time.LocalDate;
import java.util.*;


public class Location {

    private LocalDate dateDebut;
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
    public void setDateDebut(LocalDate e){
        this.dateDebut = e;
    }
    //Fonction qui sert à reinitialisé une date
    public void remiseZero(){
        this.dateFin = LocalDate.parse("1975-12-12");
    }
    //Fonction qui sert à vérifier que la date de fin saisie ne soit pas avant chronoligiquement la date de début inscrite
    public boolean dateAfter(LocalDate dateFin,  LocalDate dateDebut) {
        if(dateFin.isBefore(dateDebut)) { System.out.println("Vous ne pouvez pas louer avant une date de fin antérierur a une date de début"); }
        else { System.out.println("la date est valide"); }
        return false; }
}