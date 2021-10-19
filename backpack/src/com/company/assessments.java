package com.company;

public interface assessments {
    void setQuestion(String a, Object temp);
    void setMarks(int m, Object temp);
    int getMarks();
    void setOpen();
    boolean getOpen();
    String getQuestion();
}
