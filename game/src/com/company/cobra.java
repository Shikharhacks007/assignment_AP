package com.company;

public class cobra extends snake{
    protected int floorPosition;
    protected int floorPoints;
    public cobra(int a) {
        super(a);
        this.floorPosition = a;
        this.floorPoints = -4;
    }

    @Override
    public String toString() {
        return "Cobra floor";
    }

    @Override
    public int getFloorPoints(){
        return floorPoints;
    }

    @Override
    void jump(player pobj, floor fobj) {
        pobj.setScore(fobj,fobj.getFloorPoints());
    }

    @Override
    public int getFloorPosition(){
        return floorPosition;
    }

    @Override
    public void goFloor(){
        System.out.println("move");
    }
}
