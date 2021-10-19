package com.company;

public class submissions {
    private int grade;
//    private assessments temp;
    private String submissionData;
    private boolean graded;
    private String gradedBy;

    public submissions(){
        grade = 0;
        submissionData="";
        graded = false;
    }

    void setGrade(Object temp, int grade){
        if (temp instanceof instructor){
            this.grade = grade;
        }
        else{
            System.out.println("not allowed");
        }
    }

    void setGradedBy(Object temp, String name){
        if (temp instanceof instructor){
            gradedBy = name;
            graded = true;
        }
        else{
            System.out.println("not allowed");
        }
    }

    String getGradedBy(){
        return gradedBy;
    }

    int getGrade(){
        return grade;
    }

    void setSubmissionFile(String str){
        submissionData = str;
    }

    String getSubmissionData(){
        return submissionData;
    }

    boolean getGraded(){
        return graded;
    }
}
