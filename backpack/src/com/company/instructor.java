package com.company;


public class instructor {
    private final String course;
    private String name;
    public instructor(String name){
        course = "course1";
        this.name = name;
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
