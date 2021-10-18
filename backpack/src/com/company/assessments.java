package com.company;

public interface assessments {
    void setQuestion(String a, Object temp);
    void setMarks(int m, Object temp);
    int getMarks();
    void setDone();
    boolean getDone();
    String getQuestion();
}
