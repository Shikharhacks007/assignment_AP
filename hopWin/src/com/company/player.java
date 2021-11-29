package com.company;

import java.lang.Math.*;

public class player {
    private int position;

    public void hop(Object obj){
        if (obj instanceof game){
            this.position = (int) ((Math.random() * (30 - 1)) + 1);
        }
    }

    public int getPosition(){
        return position;
    }

}
