package com.company;


import java.util.ArrayList;

public class instructor implements user {
    private final String course;
    private final String name;
    public instructor(String name){
        course = "course1";
        this.name = name;
    }

    String getCourse(){
        return course;
    }


    String getName(){
        return name;
    }

    @Override
    public void menu() {
        System.out.println("""
                1. Add class material
                2. Add assessments
                3. View lecture materials
                4. View assessments
                5. Grade assessments
                6. Close assessment
                7. View comments
                8. Add comments
                9. Logout
                """);

    }

    @Override
    public void view_comments(ArrayList<comment> getComments) {
        for (comment getComment : getComments) {
            System.out.println(getComment.getMessage() + " - " + getComment.getName());
            System.out.println(getComment.getDate());
        }
    }

    @Override
    public void add_comments(ArrayList<comment> getComments, comment obj) {
        getComments.add(obj);
    }
}
