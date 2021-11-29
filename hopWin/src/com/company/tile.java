package com.company;

public class tile{
    private final int position;
    private final softToy toy;
    public tile(int a, softToy toy){
        position = a;
        this.toy = toy;
    }

    public softToy getToy(){
        return toy;
    }

    public int getNumber(){
        return position;
    }

    public softToy getClone(){
        return toy.clone(this);
    }
}
