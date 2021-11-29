package com.company;

import java.util.ArrayList;

public class bucket {
    private final ArrayList<softToy> prizes;

    public bucket(){
        prizes = new ArrayList<>();
    }

    public void addPrize(softToy sobj, Object obj){
        if (obj instanceof game){
            prizes.add(sobj);
        }
        else{
            System.out.println("Not Allowed");
        }
    }

    public ArrayList<softToy> getPrizes(){
        return prizes;
    }
}
