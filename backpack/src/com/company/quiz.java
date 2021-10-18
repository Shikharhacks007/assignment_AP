package com.company;

public class quiz implements assessments {
    private int marks;
    @Override
    public void setMarks(int m){
        marks = m;
    }

    int getMarks() {
        return marks;
    }
}
