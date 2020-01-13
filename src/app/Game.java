package app;


import java.util.ArrayList;



/**
 * Game
 */
public class Game {
       static ArrayList position = new ArrayList<>();
       public static final String ANSI_RED = "\u001B[31m";
       public static final String ANSI_RESET = "\u001B[0m";

       public static void drawUi() {
              System.out.println(
                                            ".s::::::::::::::::s/:::::::::::::::++:::::::::::::s:::::::::::::::/s:::::::::::::s:::::::::::::::::/s:::::::::::::::::::::::/s:- \n"
                                          + "./  rytirska ul.   /` ovocny trh   --  na prikope +  parizska ul. + celetna ul.  + nam. republiky  `/    hradcanska ul      :- \n"
                                          + "./      " + position.get(12) + "       /`   " + position.get(13) + "       --  " + position.get(14) + "       +   " + position.get(15) + "        +  " + position.get(16) + "        +    " + position.get(17) + "         `/      " + position.get(18) + "             :- \n"
                                          + "./                /`               --             +               +              +                 `/                       :- \n"
                                          + "./       " + GetInfo.getBuildingByPosition(12).owner + "         /`   " + GetInfo.getBuildingByPosition(13).owner + "          --   " + GetInfo.getBuildingByPosition(14).owner + "         +   " + GetInfo.getBuildingByPosition(15).owner + "           +   " + GetInfo.getBuildingByPosition(16).owner + "          +        " + GetInfo.getBuildingByPosition(17).owner + "        `/       " + GetInfo.getBuildingByPosition(18).owner + "               :- \n"
                                          + "`o-----------------y:--------------::-------------:---------------:--------------:------------------:o-----------+------------ \n"
                                          + "`/ vodickova ul.   s`                                                                              `/    malostranske nam   :- \n"
                                          + "`+      " + position.get(11) + "       /`                                                                              `/       " + position.get(19) + "            :- \n"
                                          + "`+                 /`                                                                              `/                       :- \n"
                                          + "`/      " + GetInfo.getBuildingByPosition(11).owner + "          s`                                                                              `/       " + GetInfo.getBuildingByPosition(19).owner + "               :- \n"
                                          + "`s:::::::::::::::::o                                                                              `o------------------------+- \n"
                                          + "`+ jungmannova ul. /`                                                                              `/         kampa         :- \n"
                                          + "`+       " + position.get(10) + "      /`                                                                              `/        " + position.get(20) + "           :- \n"
                                          + "`+                 /`                 player 1                              player 2               `/                       :- \n"
                                          + "`+       " + GetInfo.getBuildingByPosition(10).owner + "          /`          amount of credits: " + GetInfo.amountOfMoneyOwned(Player.allPlayers.get(1)) + "               amount of credits: "+ GetInfo.amountOfMoneyOwned(Player.allPlayers.get(2)) +"      `/       " + GetInfo.getBuildingByPosition(20).owner + "               :- \n"
                                          + "`s:::::::::::::::::s`                                                                              `o-----------------------+- \n"
                                          + "`/ narodni trida   s`                         active player:                                       `/     karlova ulice     :- \n"
                                          + "`/      " + position.get(9) + "       s`                                                                              `/          " + position.get(21) + "         :- \n"
                                          + "`/                 s`                                                                              `/                       :- \n"
                                          + "`/    " + GetInfo.getBuildingByPosition(9).owner + "            s`                                                                              `/    " + GetInfo.getBuildingByPosition(21).owner + "                  :- \n"
                                          + ".o:::::::::::::::::y`                                                                              `o-------+----------------- \n"
                                          + "`+ smetanovo nabr. /`                                                                              `/    staromestske nam.  :- \n"
                                          + "`+    " + position.get(8) + "         /`                                                                              `/          " + position.get(22) + "         :- \n"
                                          + "`/                 o`                                                                              `/                       :- \n"
                                          + "`/      " + GetInfo.getBuildingByPosition(8).owner + "          o`                                                                              `/          " + GetInfo.getBuildingByPosition(22).owner + "            :- \n"
                                          + "`o-----------------s`                                                                              `o-----------------------+. \n"
                                          + "`/ masarykovo nabr./`                                                                              `+     vaclavske nam.    :- \n"
                                          + "`/     " + position.get(7) + "        /`                                                                              `/          " + position.get(23) + "         :- \n"
                                          + "`/                 /`                                                                              `/                       :- \n"
                                          + "`/      " + GetInfo.getBuildingByPosition(7).owner + "          /`                                                                              `/          " + GetInfo.getBuildingByPosition(23).owner + "            :- \n"
                                          + "`s-----------------o:-----------------::----------------+-------------+---------------+------------------:o-----------------+- \n"
                                          + "`+ rasinovo nabr.  /` vinohradska ul. -- jindrisska ul. +  panska ul. + revolucni ul. + Klimentská ulice `/      Start!    :- \n"
                                          + "`+      " + position.get(6) + "       /`    " + position.get(5) + "         --    " + position.get(4) + "        +  " + position.get(3) + "       +   " + position.get(2) + "        +     " + position.get(1) + "         `/     " + position.get(0) + "       :- \n"
                                          + "`+                 /`                 --                +             +               +                  `/    get 200!    :- \n"
                                          + "`+        " + GetInfo.getBuildingByPosition(6).owner + "        /`        " + GetInfo.getBuildingByPosition(5).owner + "        --        " + GetInfo.getBuildingByPosition(4).owner + "       +       " + GetInfo.getBuildingByPosition(3).owner +  "     +       " + GetInfo.getBuildingByPosition(2).owner + "       +         " + GetInfo.getBuildingByPosition(1).owner + "        `/                :- \n"
                                          + "`s.................o-.................//...............-o.............o...............o..................-o-----------------+ \n"
                                          + "```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````` \n");
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
              
              for (int i = 0; i < 24; i++) {
                     position.add("    ");
              }
              

       }

       public static void wait(int miliseconds) throws InterruptedException {
              Thread.sleep(miliseconds);
       }

       public static void playerSteppedOnTile() throws InterruptedException {
              int position = GetInfo.getPlayerOnTurn().position;
              int rent = GetInfo.getBuildingByPosition(position).rent;
              

              if (GetInfo.getBuildingByPosition(position).owner == 0) { //if the owner is the bank
                     Logic.buyBuilding(GetInfo.getBuildingByPosition(position));

              } else if (GetInfo.getBuildingByPosition(position).owner == GetInfo.getPlayerOnTurn().id) { //if owner is the active player
                     System.out.println("This property is owned by you! You can procrastinate this turn!");
                     String waste = Logic.sc.nextLine();
                     Logic.endTurn();

              } else { // if there is another owner
                     Logic.payRent(position, rent);

              }
       }

       public static void main(String[] args) {

              try {
                     drawUi();
                     Logic.movePlayer(); // posunuti hrace
                     drawUi();
                     wait(1000);
                     playerSteppedOnTile(); // hrac slapl na policko
              } catch (Exception e) {
                     initializeData(); // inicializace dat
                     main(null);
              }

       }
}