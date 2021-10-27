package com.company;

class snake extends floor{
//    protected int floorPosition;
//    protected int floorPoints;
    public snake(int a) {
        super(a);
        this.floorPosition = a;
        this.floorPoints = -2;
        this.gotoFloor = -4;
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

    public int  getgoFloor(){
        return gotoFloor;
    }

    public void goFloor(player pobj, floor fobj){
        pobj.setPosition(fobj, getgoFloor());
        System.out.println("Player position Floor- " + pobj.getPosition());
        System.out.println(pobj.getName()+ " has reached an empty floor");
        emptyFloor temp = new emptyFloor(Integer.MAX_VALUE);
        fobj.jump(pobj, temp);
        System.out.println("Total points " + pobj.getScore());
    }
}
