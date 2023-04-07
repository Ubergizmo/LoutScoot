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
            return "Disponible à la location";
        }
        else {
            return "Indisponible à la location";
        }
    }
    public void setFalse(){
        this.disponibilite = false;
    }
    public void setTrue(){
        this.disponibilite = true;
    }
    public boolean getEtatVehicule(){
        return etatVehicule;
    }
    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }
}