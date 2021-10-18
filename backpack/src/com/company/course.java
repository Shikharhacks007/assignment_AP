package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class course {
    private final ArrayList <student> students;
    private final ArrayList <instructor> instructors;
    private final ArrayList <assignment> assignments;
    private final ArrayList <quiz> quizzes;
    private final ArrayList <slide> slides;
    private final ArrayList <video> videos;
    public course(){
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        assignments = new ArrayList<>();
        quizzes = new ArrayList<>();
        slides = new ArrayList<>();
        videos = new ArrayList<>();
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

    public void setVideos(video obj){
        videos.add(obj);
    }

    ArrayList<video> getVideos(){return videos;}

    void menuInstructor() {
        instructor iobj = new instructor("Josh");
        getInstructors().add(iobj);
        Scanner sc = new Scanner(System.in);
        System.out.println("instructors:");
        if (getInstructors().size()>=1) {
            for (int i = 0; i < getInstructors().size(); i++) {
                System.out.println(i + ". " + getInstructors().get(i).getName());
            }
            System.out.print("Chose id: ");
            // id of the instructor is received here
            int ch = sc.nextInt();
            System.out.println("Welcome: " + getInstructors().get(ch).getName());
            System.out.println("Instructor Menu");
            int selection = sc.nextInt();
            while (selection != 9){
                switch (selection){
                    case 1:
                        System.out.println("lol");
                        break;
                    case 2:
                        System.out.println("lol again");
                        break;
                }
                System.out.println();
                System.out.println("Welcome: " + getInstructors().get(ch).getName());
                System.out.println("instructors menu");
                selection = sc.nextInt();
            }
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
                        for (int i = 0; i < getSlides().size(); i++) {
                            System.out.println("Title" + getSlides().get(i).getTitle());
                            for (int j = 0; j < getSlides().get(i).getCount(); j++) {
                                System.out.println("Slide " + j + getSlides().get(i).getSlides().get(j));
                            }
                            System.out.println("Number of Slides: " + getSlides().get(i).getCount());
                            System.out.println("Date of Upload: " + getSlides().get(i).getDate());
                            System.out.println("Uploaded by: " + getSlides().get(i).getUploadedBy());
                            System.out.println();
                        }

                        for (int i = 0; i < getVideos().size(); i++) {
                            System.out.println("Title of video: " + getVideos().get(i).getTitle());
                            System.out.println("Video File" + getVideos().get(i).getVideoFile());
                            System.out.println("Date of Upload: " + getVideos().get(i).getDate());
                            System.out.println("Uploaded by: " + getVideos().get(i).getUploadedBy());
                        }
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
                    case 6:
                        System.out.println("view comments");
                }

                System.out.println();
                System.out.println("Welcome: " + getStudents().get(ch).getName());
                System.out.println("Student menu");
                selection = sc.nextInt();
            }
        }
    }
}
