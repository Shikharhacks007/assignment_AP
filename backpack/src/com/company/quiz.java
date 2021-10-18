package com.company;

public class quiz implements assessments {
    private int marks;
    private String question;

    @Override
    public void setMarks(int m){
        marks = m;
    }

    @Override
    public void setQuestion(String a){
        question = a;
    }

    int getMarks() {
        return marks;
    }

    String getQuestion(){
        return question;
    }
}
