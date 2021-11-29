package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class game {
    private final ArrayList<tile> carpet;
    private final calculator cal;
    private final bucket buk;
    private final player Player;
    private game temp;
    private tile pTile;
    private final BufferedReader br;
    Random random;

    public game(){
        carpet = new ArrayList<>();
        cal = new calculator();
        buk = new bucket();
        Player = new player();
        pTile = new tile(0,new softToy(null));
        br = new BufferedReader(new InputStreamReader(System.in));
        random = new Random();
    }

    private void initializeCarpet(){
        for (int i = 1; i <= 20; i++) {
            carpet.add(new tile(i,new softToy("Gift"+i)));
        }
    }

    private String randomString(){
        String a = "ABCDEFGHIJKLMNOPQURSTUVWXYZabcdefghijklmnopqurstuvwxyz";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int nextRand = (int) (random.nextFloat() * (a.length() - 1));
            ans.append(a.charAt(nextRand));
        }
        return ans.toString();
    }

    private void askQuestion() throws IOException {
        Object answer;
        Object a;
        Object b;
        while (true){
            System.out.println("Question answer Round. Integer or String ?");
            String choice = br.readLine();
            if (choice.equalsIgnoreCase("integer")){
                a = (int) (Math.random() * ((Integer.MAX_VALUE/2) - (Integer.MIN_VALUE/2)) + Integer.MIN_VALUE);
                b = (int) (Math.random() * ((Integer.MAX_VALUE/2) - (Integer.MIN_VALUE/2)) + Integer.MIN_VALUE);
                System.out.println("Calculate the result of " + a + " divided by" + b);
                answer = Integer.parseInt(br.readLine());
                System.out.println(cal.calculate(a,b));
                try{
                    if (cal.calculate((Integer)a,(Integer)b).equals((Integer)answer)){
                        System.out.println("You won a" + pTile.getClone().getName() +" soft toy");
                        buk.addPrize(pTile.getClone(), temp);
                    }
                    else{
                        System.out.println("Wrong answer");
                        System.out.println("You did not win any soft toy");
                    }
                }
                catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            else if (choice.equalsIgnoreCase("string")){
                a = randomString();
                b = randomString();
                System.out.println("Calculate the concatenation of strings "+ a + " and " + b);
                answer = br.readLine();
                try{
                    if (cal.calculate(a,b).equals(answer)){
                        System.out.println("You won a" + pTile.getClone().getName() +" soft toy");
                        buk.addPrize(pTile.getClone(), temp);
                    }
                    else{
                        System.out.println("Wrong answer");
                        System.out.println("You did not win any soft toy");
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            }
            else{
                System.out.println("Enter choice again");
                choice = br.readLine();
            }
        }
    }


    public void start() throws IOException, ExceptionHandler {
        temp = new game();
        initializeCarpet();
        System.out.println("Game ready to play");
        int n = 1;
        int move;
        while (n <= 5){
            System.out.print("Press enter for your " + n + " move");
            char c = (char)br.read();
            while (true){
                try{
                    if (c == '\n') {
                        Player.hop(temp);
                        move = Player.getPosition();
                        try{
                            pTile = carpet.get(move);
                            System.out.println("You landed on Tile " + pTile.getNumber());
                            if (pTile.getNumber() % 2 != 0){
                                askQuestion();
                            }
                            else{
                                try {
                                    buk.addPrize(pTile.getClone(), temp);
                                }
                                catch (NullPointerException e){
                                    System.out.println(e.getMessage());
                                }

                            }
                            break;
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("You have jumped too far into the mud puddle");

                        }
                    }
                    else
                    {
                        throw new ExceptionHandler("You were supposed to enter the enter button");
                    }
                }
                catch (ExceptionHandler e){
                    System.out.println(e.getMessage());
                    c = (char)br.read();
                }
            }
            n++;
        }



        System.out.println("Game Over");
        if (!buk.getPrizes().isEmpty()){
            System.out.println("Soft toys won by you are:");
            for (int i = 0; i < buk.getPrizes().size(); i++) {
                System.out.print(buk.getPrizes().get(i).getName() + ", ");
            }
        }
        else{
            System.out.println("You didnt win any price");
        }
    }
}
