package com.company;

public class player{
    private final String name;
    private int score;
    private int position;

    public player(String a){
        score = 0;
        name = a;
        position = -1;
    }

    public int getScore(){
        return score;
    }

    public void setScore(Object obj,int a){
        if (obj instanceof floor){
            score += a;
        }
    }

    public String getName(){
        return name;
    }

    public void setPosition(Object obj, int temp){
        if (obj instanceof game || obj instanceof floor){
            position += temp;
        }
    }

    public int getPosition(){
        return position;
    }

}
