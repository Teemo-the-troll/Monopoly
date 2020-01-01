package app;

import java.util.ArrayList;

public class Player {
    public static ArrayList<Player> allPlayers = new ArrayList<>();
    int position = 0;
    int moneyOwned = 1500;
    boolean isOnturn;
    int id;

    public Player(int position, int moneyOwned, Boolean isOnturn, int id) {
        this.id = id;
        this.position = position;
        this.moneyOwned = moneyOwned;
        this.isOnturn = isOnturn;
        allPlayers.add(this);

    }
    

   
    
}