package Model.model;

import java.util.*;

import java.util.Vector;

public class Entreprise {

    public String nom;
    public String adresse;
    private Vector<Client> clients;

    public Entreprise(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.clients = new Vector<Client>();
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void supprimerClient(Client client) {
        clients.remove(client);
    }

    public String printEnts(String nom, String adresse) {
        return nom + " - " + adresse;
    }

}
