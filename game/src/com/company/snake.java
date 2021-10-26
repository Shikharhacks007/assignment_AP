package com.company;

class snake extends floor{
    protected int floorPosition;
    protected int floorPoints;
    public snake(int a) {
        super(a);
        this.floorPosition = a;
        this.floorPoints = -2;
    }

    @Override
    public String toString() {
        return "snake floor";
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

    public void goFloor(){
        System.out.println("move");
    }
}
