package com.company;


public class instructor {
    private final String course;
    private String name;
    public instructor(){
        course = "course1";
    }

    void setName(String n){
        name = n;
    }

    String getCourse(){
        return course;
    }

    String getName(){
        return name;
    }
}
