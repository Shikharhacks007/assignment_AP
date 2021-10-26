package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Author Shikhar Sharma 2020121

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("started game snakes and ladders");
        System.out.println("Enter the player name and hit enter");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        game g = new game(br.readLine());
        g.start(g);
    }
}
