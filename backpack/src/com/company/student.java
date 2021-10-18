package com.company;

import java.util.ArrayList;

public class student {
    private final String name;
    private final ArrayList <assignment> pendingAssignments;
    private final ArrayList <quiz> pendingQuizzes;
    public student(String name){
        this.name = name;
        pendingAssignments = new ArrayList<>();
        pendingQuizzes = new ArrayList<>();
    }

    String getName(){
        return name;
    }

    void addPendingAssignments(assignment obj){
        pendingAssignments.add(obj);
    }

    void addPendingquizzes(quiz obj){
        pendingQuizzes.add(obj);
    }

    ArrayList<assignment> getAssignments(){
        return pendingAssignments;
    }

    ArrayList<quiz> getQuizzes(){
        return pendingQuizzes;
    }
}
