package com.company;

public class ladder extends floor {
    protected int floorPosition;
    protected int floorPoints;

    public ladder(int a) {
        super(a);
        this.floorPosition = a;
        this.floorPoints = 2;
        this.gotoFloor = 4;
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

    public void goFloor(){
        System.out.println("move");
    }
}
