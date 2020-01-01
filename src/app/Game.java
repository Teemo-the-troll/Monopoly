package app;

import java.util.Scanner;

/**
 * Game
 */
public class Game {

       public static void drawUi() {
              System.out.println(
                            ".s:::::::::::::s/:::::::::::++:::::::::::::s:::::::::::/s:::::::::::::s::::::::::::::/s:::::::::::::- \n"
                                          + "./             /`           --             +            +             +             `/             :- \n"
                                          + "./             /`           --             +            +             +             `/             :- \n"
                                          + "./             /`           --             +            +             +             `/             :- \n"
                                          + "./             /`           --             +            +             +             `/             :- \n"
                                          + "`o-------------y:-----------::-------------:------------:-------------:-------------:o-----------+--- \n"
                                          + "`/             s`                                                                   `/             :- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`/             s`                                                                   `/             :- \n"
                                          + "`/             s`                                                                   `/             :- \n"
                                          + "`s:::::::::::::o                                                                    `o-------------+- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`s:::::::::::::s`                                                                   `o-------------+- \n"
                                          + "`/             s`                                                                   `/             :- \n"
                                          + "`/             s`                                                                   `/             :- \n"
                                          + "`/             s`                                                                   `/             :- \n"
                                          + ".o:::::::::::::y`                                                                   `o-------+------- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`+             /`                                                                   `/             :- \n"
                                          + "`/             o`                                                                   `/             :- \n"
                                          + "`/             o`                                                                   `/             :- \n"
                                          + "`o-------------s`                                                                   `o--------------+. \n"
                                          + "`/             /`                                                                   `+             :- \n"
                                          + "`/             /`                                                                   `/             :- \n"
                                          + "`/             /`                                                                   `/             :- \n"
                                          + "`s-------------o:----------::-------------+-------------+--------------+------------:o----------------+- \n"
                                          + "`+             /`          --             +             +              +            `/             :- \n"
                                          + "`+             /`          --             +             +              +            `/             :- \n"
                                          + "`+             /`          --             +             +              +            `/             :- \n"
                                          + "`s.............o-..........//............-o.............o..............o................-o----------+ \n"
                                          + "````````````````````````````````````````````````````````````````````````````````````````````````````` \n");
       }

       public static void initializeData() {
              Player player1 = new Player(0, 1500, true, 1);
              Player player2 = new Player(0, 1500, false, 2);
              Building buld1 = new Building(1, 50, 6, "seda", 0);
              Building buld2 = new Building(2, 50, 6, "seda", 0);
              Building buld3 = new Building(3, 65, 8, "seda", 0);
              Building buld4 = new Building(4, 80, 14, "hneda", 0);
              Building buld5 = new Building(5, 80, 14, "hneda", 0);
              Building buld6 = new Building(6, 90, 16, "hneda", 0);
              Building buld7 = new Building(7, 110, 20, "zelena", 0);
              Building buld8 = new Building(8, 110, 20, "zelena", 0);
              Building buld9 = new Building(9, 130, 23, "zelena", 0);
              Building buld10 = new Building(10, 150, 26, "ruzova", 0);
              Building buld11 = new Building(11, 150, 26, "ruzova", 0);
              Building buld12 = new Building(12, 170, 29, "ruzova", 0);
              Building buld13 = new Building(13, 190, 32, "fialova", 0);
              Building buld14 = new Building(14, 190, 32, "fialova", 0);
              Building buld15 = new Building(15, 210, 35, "fialova", 0);
              Building buld16 = new Building(16, 230, 38, "cervena", 0);
              Building buld17 = new Building(17, 230, 38, "cervena", 0);
              Building buld18 = new Building(18, 250, 41, "cervena", 0);
              Building buld19 = new Building(19, 250, 41, "zluta", 0);
              Building buld20 = new Building(20, 270, 44, "zluta", 0);
              Building buld21 = new Building(21, 290, 47, "zluta", 0);
              Building buld22 = new Building(22, 300, 50, "zlata", 0);
              Building buld23 = new Building(23, 320, 53, "zlata", 0);
       }

       public static void wait(int miliseconds) throws InterruptedException {
              Thread.sleep(miliseconds);
       }

       public static void playerSteppedOnTile() {
              int position = GetInfo.getPlayerOnTurn().position;
              int rent = GetInfo.getBuildingByPosition(position).rent;
              Scanner sc = new Scanner(System.in);

              if (GetInfo.getBuildingByPosition(position).owner == 0) {
                     Logic.buyBuilding(GetInfo.getBuildingByPosition(position));

              } else if (GetInfo.getBuildingByPosition(position).owner != GetInfo.getPlayerOnTurn().id) {
                    System.out.println("This property is owned by you! You can procrastinate this turn!");
                    String waste = sc.nextLine();
                     Logic.endTurn();
              } else {
                     Logic.payRent(position, rent);
                     
              }
       }

       public static void main(String[] args) {

              try {
                     Logic.movePlayer(); // posunuti hrace
                     wait(1000);
                     playerSteppedOnTile(); // hrac slapl na policko
              } catch (Exception e) {
                     initializeData(); // inicializace dat
                     main(null);
              }

       }
}