package com.company;

public class quiz implements assessments {
    private int marks;
    private String question;
    private boolean open;

    public quiz(){
        marks = 0;
        open = true;
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

    @Override
    public int getMarks() {
        return marks;
    }

    @Override
    public String getQuestion(){
        return question;
    }

    @Override
    public boolean getOpen(){
        return open;
    }

    @Override
    public void setOpen(){
        open = false;
    }
}
