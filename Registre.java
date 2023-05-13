package Model.model;

public class Registre {
    private Client client;
    private int n;

    public Registre( Client a , int b){

        this.client = a;
        this.n = b;
    }
    public int getN(){return this.n;}
    public String getNom(){
        return this.client.getNom();
    }
    public String getPrenom(){
        return this.client.getPrenom();
    }
    public String getNumero(){
        return this.client.getNumero();
    }
    public Client getClient(){return this.client;}
    public void setN(){this.n++;}
    public void setClient(Client x){this.client=x;}
}
