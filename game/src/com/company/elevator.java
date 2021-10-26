package com.company;

public class elevator extends ladder {
    protected int floorPosition;
    protected int floorPoints;

    public elevator(int a) {
        super(a);
        this.floorPosition = a;
        this.floorPoints = 4;
    }

    @Override
    public String toString(){
        return "ladder";
    }

    @Override
    int getFloorPosition() {
        return floorPosition;
    }

    public int getFloorPoints(){
        return floorPoints;
    }

    @Override
    void jump(player pobj, floor fobj) {
        pobj.setScore(fobj,fobj.getFloorPoints());
    }

    @Override
    public void goFloor(){

    }
}
