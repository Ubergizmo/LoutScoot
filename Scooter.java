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
    }
    public String printEtat(){
        if (this.getEtatVehicule()) {
            return "Véhicule en bon état";
        }
        else {
            return "Véhicule en panne";
        }
    }
    public void setFalse(){
        this.disponibilite = false;
    }
    public void setTrue(){
        this.disponibilite = true;
    }
    public void setEtatF(){this.etatVehicule = false;}
    public void setEtatT(){this.etatVehicule = true;}
    public boolean getEtatVehicule(){
        return etatVehicule;
    }
    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

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
    }
}