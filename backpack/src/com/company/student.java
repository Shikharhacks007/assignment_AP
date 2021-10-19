package com.company;

import java.util.ArrayList;
import java.util.*;

public class student {
    private final String name;
    private final ArrayList <assessments> pendingAssessments;
    private final ArrayList <submissions> submissionsDone;
    Map <assessments,submissions> work;

    public student(String name){
        this.name = name;
        pendingAssessments = new ArrayList<>();
        submissionsDone = new ArrayList<>();
        work = new HashMap<>();
    }

    String getName(){
        return name;
    }

    public void setSubmissionsDone(assessments obj, submissions sobj){
        work.put(obj, sobj);
    }

    void addPendingAssessments(assessments obj){
        pendingAssessments.add(obj);
    }

    ArrayList<assessments> getPendingAssessments(){
        return pendingAssessments;
    }
}
