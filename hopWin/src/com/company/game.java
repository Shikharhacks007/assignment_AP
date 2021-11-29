package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class game {
    private final ArrayList<tile> carpet;
    private final calculator cal;
    private final bucket buk;
    private player Player;
    private game temp;
    private tile pTile;
    private BufferedReader br;

    public game(){
        carpet = new ArrayList<tile>();
        cal = new calculator();
        buk = new bucket();
        Player = new player();
        temp = new game();
        pTile = new tile(0,new softToy(null));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void initializeCarpet(){
        for (int i = 1; i <= 20; i++) {
            carpet.add(new tile(i,new softToy("Teddy")));
        }
    }

    private void askQuestion() throws IOException {
        while (true){
            System.out.println("Question answer Round. Integer or String ?");
            String choice = br.readLine();
            if (choice.toLowerCase().equals("integer")){
                System.out.println("Calculate the result of 2000 divided by 100");
                break;
            }
            else if (choice.toLowerCase().equals("string")){
                //do something
                break;
            }
            else{
                System.out.println("Enter choice again");
                choice = br.readLine();
            }
        }
    }

    private boolean checkAnswer() {
        return true;
    }


    public void start() throws IOException {
        initializeCarpet();
        System.out.println("Game ready to play");

        int n = 1;
        int move = 0;
        char c = (char)br.read();
        while (n <= 5){
            System.out.println("Press enter for your " + n + " move");

            if ((char)br.read() == ' ') {
                System.out.println("Please click the enter key");
            }

            else if (c == '\n') {
                Player.hop(temp);
                move = Player.getPosition();
                try{
                    pTile = carpet.get(move);
                    askQuestion();
                    if (checkAnswer()){
                        buk.addPrize(pTile.getClone(), temp);
                    }
                    else{
                        System.out.println("Wrong answer");
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("You have jumped too far");
                }

                n++;
            }

        }
    }
}
