package Model.model;


import java.util.*;


public class Scooter {

    private static int idCounter = 0;
    private int id;
    private String model;
    private int rentPrice;
    private int kilometre;
    private boolean disponibilite;
    private boolean etatVehicule;

    public Scooter( String model, int c, int d, boolean e, boolean f) {
        this.id = ++idCounter;
        this.model = model;
        this.rentPrice = c;
        this.kilometre = d;
        this.disponibilite = e;
        this.etatVehicule = f;
    }


    public int getId(){
        return id;
    }
    public String getModel(){
        return model;
    }
    public int getRentPrice(){
        return rentPrice;
    }
    public int getKilometre(){
        return kilometre;
    }
    public boolean getDisponibilite(){
        return disponibilite;
    }
    public String printDisponibilite(){
        if (this.getDisponibilite()) {
            return "Pas en Location";
        }
        else {
            return "En Location";
        }
    }//Retourne un message en fonction de la disponibilité du scooter
    public String printEtat(){
        if (this.getEtatVehicule()) {
            return "Véhicule en bon état";
        }
        else {
            return "Véhicule en panne";
        }
    }//Retourne un message en fonction de l'état du scooter
    public void setFalse(){
        this.disponibilite = false;
    }//Change l'etat de la variable disponibilité en false
    public void setTrue(){
        this.disponibilite = true;
    }//Change l'etat de la variable disponibilité en true
    public void setEtatF(){this.etatVehicule = false;}//Change l'etat de la variable étatVehicule en false
    public void setEtatT(){this.etatVehicule = true;}//Change l'etat de la variable étatVehicule en true
    public boolean getEtatVehicule(){
        return etatVehicule;
    }
    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }//Change l'etat de la variable kilometre avec une nouvelle valeur

    public String printEtatParc() {
        if(this.getDisponibilite()&&this.getEtatVehicule()){
            return "Disponible à la location!";
        } else if (this.getDisponibilite()&&!this.getEtatVehicule()) {
            return "Véhicule en panne!";
        }
        else if (!this.getDisponibilite()&&this.getEtatVehicule()) {
            return "Véhicule en location!";
        }
return null;
    }//Retourne un message en fonction de l'état du scooter et de sa disponibilité
}