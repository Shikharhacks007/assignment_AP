package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, ExceptionHandler {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hit enter to initialize the game");
        char c = (char)br.read();
        if (c == ' ') {
            System.out.println("Please click the enter key");
        }
        else if (c == '\n') {
            game hopWin = new game();
            hopWin.start();
        }
    }
}
