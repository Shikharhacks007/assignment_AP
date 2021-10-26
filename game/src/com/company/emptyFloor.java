package com.company;

public class emptyFloor extends floor {
    public emptyFloor(int a) {
        super(a);
        this.floorPosition = a;
        this.floorPoints = 1;
    }

    @Override
    public String toString() {
        return "empty floor";
    }

    @Override
    int getFloorPosition() {
        return floorPosition;
    }

    @Override
    int getFloorPoints() {
        return floorPoints;
    }

    @Override
    public void jump(player pobj, floor fobj) {
        pobj.setScore(fobj,fobj.getFloorPoints());
    }
}