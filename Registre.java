package Louscoot;

public class Registre {
    Location[] registre;
    private int id = 0;
    public Registre(Location a ){
        id++;
        registre[id] = a;
    }
    public void printRegistre(){
        for(int i = 0; i<registre.length;i++){
            System.out.println("Le client n : "+
                    registre[i].getClient().getId()+
                    " a loué le scooter"
                    + registre[i].getScooter().getModel()+
                    "le"+registre[i].getDateDebut());
        }
    }
}

