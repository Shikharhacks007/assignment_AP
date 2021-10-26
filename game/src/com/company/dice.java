package com.company;
import java.math.*;

public class dice {
    private int move;
    public dice(){
        move=0;
    }

    private void roll() {
        move = (int) ((Math.random() * 2) + 1);
//        move = 1; //for testing purpose
    }

    public int getMove() {
        roll();
        return move;
    }
}
