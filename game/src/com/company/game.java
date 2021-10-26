package com.company;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class game {
    private final ArrayList<floor> floors;
    private final player player1;
    private final dice d;

    game(String name){
        floors = new ArrayList<>();
        player1 = new player(name);
        d = new dice();
    }

    private int[] initialize(){
        for (int i = 0; i < 14; i++) {
            if (i == 2){
                floor temp = new elevator(i);
                floors.add(temp);
            }
            else if (i == 5){
                floor temp = new snake(i);
                floors.add(temp);
            }
            else if(i == 8){
                floor temp = new ladder(i);
                floors.add(temp);
            }
            else if (i == 11){
                floor temp = new cobra(i);
                floors.add(temp);
            }
            else{
                floor temp = new emptyFloor(i);
                floors.add(temp);
            }
        }

        for (int i = 13; i > -1; i--) {
            System.out.println(i + " " + floors.get(i).getClass());
        }

        System.out.println("-----------------------------------");
        System.out.println("The game setup is ready");
        cheatSheet cheat = new cheatSheet();
        cheat.cheat();
        return cheat.way();
    }

    private void display(game gobj, int move) {
        System.out.println("Dive gave " + move);
        if (player1.getPosition() + move > 13){
            System.out.println("Sorry you cant move");
        }
        else{
            player1.setPosition(gobj,move);
            if (floors.get(player1.getPosition()) instanceof elevator) {
                independentDisplay();
                ((elevator) floors.get(player1.getPosition())).goFloor(player1,floors.get(player1.getPosition()));
            }
            else if (floors.get(player1.getPosition()) instanceof ladder) {
                independentDisplay();
                ((ladder) floors.get(player1.getPosition())).goFloor(player1,floors.get(player1.getPosition()));
            }
            else if (floors.get(player1.getPosition()) instanceof snake) {
                independentDisplay();
                ((snake) floors.get(player1.getPosition())).goFloor(player1,floors.get(player1.getPosition()));
            }
            else if (floors.get(player1.getPosition()) instanceof cobra) {
                independentDisplay();
                ((cobra) floors.get(player1.getPosition())).goFloor(player1,floors.get(player1.getPosition()));

            }
            else {
                independentDisplay();
            }
        }
    }

    private void independentDisplay() {
        floors.get(player1.getPosition()).jump(player1, floors.get(player1.getPosition()));
        System.out.println("Player position Floor- " + player1.getPosition());
        System.out.println(player1.getName()+ " has reached an " + floors.get(player1.getPosition()).toString());
        System.out.println("Total points " + player1.getScore());
    }

    private void startDisplay(game gobj, int move) {
        System.out.println("Dice gave " + move);
        player1.setPosition(gobj,1);
        System.out.println("Player position Floor- " + player1.getPosition());
        System.out.println(player1.getName() + " " + "has reached an " + floors.get(player1.getPosition()).toString());
        floors.get(player1.getPosition()).jump(player1, floors.get(player1.getPosition()));
        System.out.println("Total points " + player1.getScore());
    }

    public void start(game gobj){
        int [] way = initialize();
        player1.setScore(gobj,0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit enter to roll the dice");
        String temp = sc.nextLine();
        if (Objects.equals(temp, "dicebiased")){
            int k =1;
            int move = way[0];
            while (true){
                if (move == 2){
                    System.out.println("Dice gave " + move);
                    System.out.println("Game cannot start until you get 1");
                }

                else{
                    startDisplay(gobj, move);
                    while (player1.getPosition() < 13){
                        System.out.println("Hit enter to roll the dice");
                        sc.nextLine();
                        move = way[k];
                        display(gobj, move);
                        ++k;

                    }
                    System.out.println("Game over");
                    System.out.println(player1.getName()+ " accumulated " +  player1.getScore() + " points");
                    break;
                }
                System.out.println("Hit enter to roll the dice");
                sc.nextLine();
                move = d.getMove();
            }
        }
        else{
            int move = d.getMove();
            while (true){
                if (move == 2){
                    System.out.println("Dice gave " + move);
                    System.out.println("Game cannot start until you get 1");
                }

                else{
                    startDisplay(gobj, move);
                    while (player1.getPosition() < 13){
                        System.out.println("Hit enter to roll the dice");
                        sc.nextLine();
                        move = d.getMove();
                        display(gobj, move);

                    }
                    System.out.println("Game over");
                    System.out.println(player1.getName()+ " accumulated " +  player1.getScore() + " points");
                    break;
                }
                System.out.println("Hit enter to roll the dice");
                sc.nextLine();
                move = d.getMove();
            }
        }


    }
}
