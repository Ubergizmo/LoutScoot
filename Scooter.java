package Louscoot;
import java.util.Scanner;

public class Scooter {
    private int id;
    private String model;
    private int rentPrice;
    private int kilometre;
    private boolean disponibilite;
    private boolean etatVehicule;

    public Scooter(int a, String b , int c , int d , boolean e, boolean f){
        this.id = a;
        this.model = b;
        this.rentPrice = c;
        this.kilometre = d;
        this.disponibilite =  e;
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


    public boolean getEtatVehicule(){
        return etatVehicule;
    }


}
