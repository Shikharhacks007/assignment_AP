package com.company;

public class quiz implements assessments {
    private int marks;
    private String question;
    private boolean done;

    public quiz(){
        marks = 0;
        done = false;
        question = "";
    }

    @Override
    public void setMarks(int m, Object temp){
        if (temp instanceof instructor){
            marks = m;
        }
        else{
            System.out.println("Sorry not allowed");
        }
    }

    @Override
    public void setQuestion(String a, Object temp){
        if (temp instanceof instructor){
            question = a;
        }
        else{
            System.out.println("Sorry not allowed");
        }
    }

    int getMarks() {
        return marks;
    }

    String getQuestion(){
        return question;
    }

    @Override
    public void setDone(){
        done = true;
    }
}
