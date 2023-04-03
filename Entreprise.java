package Model.model;

import java.util.*;

public class Entreprise {

    public String nom;
    public String adresse;
    private Vector<Client> clients; // Utilisation d'une liste pour stocker les clients de l'entreprise
    private Parc parc;
    public Entreprise(String nom, String adres, Client clients) {
        this.nom=nom;
        this.adresse=adres;
        this.clients = new Vector<Client>();

    }
    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void supprimerClient(Client client) {
        clients.remove(client);
    }


    public String printEnts(String nom, String adress) {
        return nom;
        // TODO implement here
    }

}