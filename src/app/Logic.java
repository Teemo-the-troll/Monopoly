package app;

import java.util.Scanner;

public class Logic {
    static Scanner sc = new Scanner(System.in);

    /**
     * throws 2x dice, range from 2 - 12
     * 
     * @return {int} wasThrown
     */
    public static int dice() {
        System.out.println("Hodit kostkou");
        String waste = sc.nextLine();
        int dice1 = (int) ((Math.random() * 6) + 1);
        int wasThrown = (int) ((Math.random() * 6) + dice1 + 1);
        return wasThrown;
    }

    public static void endTurn() {
        changeActivePlayer();
        Game.main(null);
    }

    public static void payRent(int position, int rent) {
        System.out.println("You stepped onto another playes's property! Pay up! Confirm by hitting enter");

        String waste = sc.nextLine();

                     Logic.transferMoney(GetInfo.getPlayerOnTurn().id, GetInfo.getBuildingByPosition(position).owner, rent);
                     System.out.println("Okay, funds transfered, next player!");
                     Logic.endTurn();
    }

    public static void movePlayer() {
        int amount = dice();
        System.out.println("posouvam hrace o: " + amount);
        if ((GetInfo.getPlayerOnTurn().position + amount) <= 23) {
            System.out.println("hrac byl na pozici:" + GetInfo.getPlayerOnTurn().position);
            GetInfo.getPlayerOnTurn().position = GetInfo.getPlayerOnTurn().position + amount;

            System.out.println("hrac je ted na pozici: " + GetInfo.getPlayerOnTurn().position);
        } else {
            GetInfo.getPlayerOnTurn().position = GetInfo.getPlayerOnTurn().position - 23 + amount;
            GetInfo.getPlayerOnTurn().moneyOwned = GetInfo.getPlayerOnTurn().moneyOwned + 200;
            System.out.println("You went trough start! 200 credits have been added to your account!");
        }
    }

    public static void buyBuilding(Building buyable) {
        System.out.println("This building isn't owned by anyone! Do you wish to buy it for " + buyable.cost + "?");
        GetInfo.getAllInfoBuilding(buyable);
        System.out.println("You have " + GetInfo.getPlayerOnTurn().moneyOwned + " credits.");
        String choice = sc.next().trim().toLowerCase();
        if (choice.matches("y")) {
            changeAmountOfFunds(GetInfo.getPlayerOnTurn(), -buyable.cost);
            setOwner(GetInfo.getPlayerOnTurn().id, buyable);
            System.out.println("You decided to buy this property. Changing the player!");
            endTurn();
        } else {
            System.out.println("Okay, you decided on not buying this property. Next player is up!");
            endTurn();
        }

    }

    public static void changeAmountOfFunds(Player client, int amount) {
        client.moneyOwned = client.moneyOwned + (amount);
    }

    public static void didLoose(Player x) {
        System.out.println("Player with id:" + x.id + " has went Bankrupt!!");
    }

    public static boolean checkAmountOfFunds(Player x, int amount) {
        if (x.moneyOwned < amount) {
            return false;
        } else {
            return true;
        }
    }

    public static void transferMoney(int sender, int reciever, int amount) {
        Player paying = GetInfo.getPlayerById(sender);
        Player gettingPaid = GetInfo.getPlayerById(reciever);
        if (checkAmountOfFunds(paying, amount)) {
            System.out.println("Sending " + amount + "credits to the other player");
            changeAmountOfFunds(paying, -amount);
            changeAmountOfFunds(gettingPaid, amount);
        } else
            didLoose(paying);
    }

    public static void setOwner(int playerId, Building buyable) {
        buyable.owner = playerId;
    }

    public static void changeActivePlayer() {

        for (int i = 1; i < Player.allPlayers.size() + 1; i++) {
            GetInfo.getPlayerById(i).isOnturn = !GetInfo.getPlayerById(i).isOnturn;
        }
    }

}