package com.company;

import java.util.ArrayList;
import java.util.*;

public class student implements user{
    private final String name;
//    private final ArrayList <assessments> pendingAssessments;
//    private final ArrayList <submissions> submissionsDone;
    Map <assessments,submissions> work;

    public student(String name){
        this.name = name;
//        pendingAssessments = new ArrayList<>();
//        submissionsDone = new ArrayList<>();
        work = new HashMap<>();
    }

    String getName(){
        return name;
    }

    public void setSubmissionsDone(assessments obj, submissions sobj){
        work.put(obj, sobj);
    }

    @Override
    public void menu() {
        System.out.println("""
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout
                """);
    }

    @Override
    public void view_comments(ArrayList<comment> getComments) {
        for (int i = 0; i < getComments.size() ; i++) {
            System.out.println(getComments.get(i).getMessage() + " - " +  getComments.get(i).getName());
            System.out.println(getComments.get(i).getDate());
        }
    }

    @Override
    public void add_comments(ArrayList<comment> getComments, comment obj) {
        getComments.add(obj);
    }
}
