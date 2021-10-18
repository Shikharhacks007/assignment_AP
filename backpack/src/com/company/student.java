package com.company;

import java.util.ArrayList;

public class student {
    private final String name;
    private final ArrayList <assessments> pendingAssessments;

    public student(String name){
        this.name = name;
        pendingAssessments = new ArrayList<>();
//        pendingQuizzes = new ArrayList<>();
    }

    String getName(){
        return name;
    }

    void addPendingAssessments(assessments obj){
        pendingAssessments.add(obj);
    }


    ArrayList<assessments> getPendingAssessments(){
        return pendingAssessments;
    }
}
