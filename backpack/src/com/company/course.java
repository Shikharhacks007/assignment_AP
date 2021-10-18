package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class course {
    private final ArrayList <student> students;
    private final ArrayList <instructor> instructors;
    private final ArrayList <assignment> assignments;
    private final ArrayList <quiz> quizzes;
    private final ArrayList <slide> slides;
    public course(){
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        assignments = new ArrayList<>();
        quizzes = new ArrayList<>();
        slides = new ArrayList<>();
    }

    void addInstructor(instructor obj){
        instructors.add(obj);
    }

    void addStudent(student obj){
        students.add(obj);
    }

    void addAssignment(assignment obj){
        assignments.add(obj);
    }

    void addQuiz(quiz obj){
        quizzes.add(obj);
    }

    void addSlide(slide obj){
        slides.add(obj);
    }

    ArrayList<instructor> getInstructors(){
        return instructors;
    }

    ArrayList<student> getStudents(){
        return students;
    }

    ArrayList<assignment> getAssignments(){
        return assignments;
    }

    ArrayList<quiz> getQuizzes(){
        return quizzes;
    }

    ArrayList<slide> getSlides(){
        return slides;
    }

    void menuInstructor() {
        System.out.println("Instructor");
        course temp = new course();
        for (int i = 0; i < temp.getInstructors().size(); i++) {
            System.out.println(temp.getInstructors().get(i));
        }
    }

    void menuStudent() {
        student sobj = new student("Shikhs");
        getStudents().add(sobj);
        Scanner sc = new Scanner(System.in);
        System.out.println("Students:");
        if (getStudents().size()>=1) {
            for (int i = 0; i < getStudents().size(); i++) {
                System.out.println(i + ". "+ getStudents().get(i).getName());
            }
            System.out.print("Chose id: ");
            // id of the student is received here
            int ch = sc.nextInt();
            System.out.println("Welcome: " + getStudents().get(ch).getName());
            System.out.println("Student Menu");
            int selection = sc.nextInt();
            while (selection != 7){
                switch (selection){
                    case 1:


                        break;
                    case 2:
                        System.out.println("View assignments");
                        break;
                    case 3:
                        System.out.println("submit");
                        break;
                    case 4:
                        System.out.println("View grades");
                        break;
                    case 5:
                        System.out.println("add comments");
                        break;
                }
                System.out.println("Student menu");
                selection = sc.nextInt();
            }
        }
    }
}
