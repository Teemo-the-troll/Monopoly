package app;

import java.util.ArrayList;

class Nemovitost {
    int position;
    int cost;
    int rent;
    int owner;
}

class Building extends Nemovitost {
    public static ArrayList<Building> Buildings = new ArrayList<>();

    public int getBuildingPosition() {
        return position;
    }

    public Building(int position, int cost, int rent, String color, int owner) {
        this.position = position;
        this.cost = cost;
        this.rent = rent;
        this.color = color;
        this.owner = owner;

        Buildings.add(this);
    }

    String color;

}

class Railway extends Nemovitost {
    // int rent = cost * amountOfRailwaysOwned;
}

class Chance {
    int id;
}