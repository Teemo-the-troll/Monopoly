package app;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GetInfo
 */

public class GetInfo {
    
    public static   void getAllInfoBuilding( Building x) {
        System.out.println("The rent is: " + x.rent + " credits");
        System.out.println("The color of this building is: "+x.color);
       

    }


    public static   Building getBuildingByPosition(int pos) {
        
        List<Building> all = Building.Buildings
            .stream()
            .filter(x -> x.getBuildingPosition() == pos)
            .collect(Collectors.toList());
        return all.get(0);
    }

    public   void setOwner(Building x) {
        x.owner = getPlayerOnTurn().id;
    }

    public   int getOwner(Building x) {
        return x.owner;
    }

    public static   Player getPlayerOnTurn() {
        List<Player> all = Player.allPlayers
        .stream()
        .filter(x -> x.isOnturn == false)
        .collect(Collectors.toList());
        return all.get(0);
    }

    public static   int amountOfMoneyOwned(final Player evaluatedPlayer) {
        return evaluatedPlayer.moneyOwned;
    }

    /**
     * searches for a player by his id
     * 
     * @param idToFind
     * @return Player
     */
    public static   Player getPlayerById(final int idToFind) {
        final List<Player> all = Player.allPlayers
        .stream()
        .filter(x -> x.id == idToFind)
        .collect(Collectors.toList());
        return all.get(0);
    }
    
}