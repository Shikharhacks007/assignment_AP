package com.company;

public abstract class floor {
    protected int floorPosition;
    protected int floorPoints;
    protected int gotoFloor;

    public floor(int a){
        floorPosition = a;
    }

    abstract public String toString();

    abstract int getFloorPosition();

    abstract int getFloorPoints();

    abstract void jump(player pobj, floor fobj);

}