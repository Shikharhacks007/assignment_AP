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
        for (int i = 0; i < getStudents().size() ; i++) {
            getStudents().get(i).addPendingAssignments(obj);
        }
    }

    void addQuiz(quiz obj){
        quizzes.add(obj);
        for (int i = 0; i < getStudents().size() ; i++) {
            getStudents().get(i).addPendingquizzes(obj);
        }
    }

    void addSlide(slide obj){
        slides.add(obj);
    }

    void addVideo(video obj){
        videos.add(obj);
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

    ArrayList<video> getVideos(){return videos;}

    public String dateSetter(){
        return "234";
    }

    private void materialVideos() {
        for (int i = 0; i < getVideos().size(); i++) {
            System.out.println("Title of video: " + getVideos().get(i).getTitle());
            System.out.println("Video File" + getVideos().get(i).getVideoFile());
            System.out.println("Date of Upload: " + getVideos().get(i).getDate());
            System.out.println("Uploaded by: " + getVideos().get(i).getUploadedBy());
        }
    }

    private void materialSlides() {
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
    }

    void menuInstructor() {
        instructor iobj = new instructor("Josh");
        addInstructor(iobj);
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
                        System.out.println("1. Add Lecture Slide");
                        System.out.println("2. Add Lecture Video");
                        int temp = sc.nextInt();
                        String content_temp;

                        if (temp == 1){
                            slide slide_obj = new slide();
                            System.out.print("Enter topic of slides: ");
                            content_temp = sc.next();
                            slide_obj.setTitle(content_temp);
                            System.out.print("Enter number of slides: ");
                            temp = sc.nextInt();
                            slide_obj.setCount(temp);
                            System.out.println("Enter content of slides");
                            for (int i = 1; i <= temp; i++) {
                                System.out.print("Content of slide " + i + ":");
                                content_temp = sc.next();
                                slide_obj.getSlides().add(content_temp);
                            }
//                            slide_obj.setDate(dateSetter);
                            slide_obj.setUploadedBy(getInstructors().get(ch).getName());
                            addSlide(slide_obj);
                        }

                        else if (temp == 2){
                            video video_obj = new video();
                            System.out.print("Enter topic of video: ");
                            content_temp = sc.next();
                            video_obj.setTitle(content_temp);
                            System.out.print("Enter filename of video: ");
                            content_temp = sc.next();

                            //checker of the validity
                            if (true){
                                video_obj.setVideoFile(content_temp);
//                                video_obj.setDate(dateSetter);
                                getVideos().add(video_obj);
                            }
                            else{
                                System.out.println("Wrong extension try again");
                            }
                            video_obj.setUploadedBy(getInstructors().get(ch).getName());
                            addVideo(video_obj);
                        }

                        break;

                    case 2:
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        temp = sc.nextInt();
                        if (temp == 1){
                            assignment a_obj = new assignment();
                            System.out.print("Enter a problem Statement: ");
                            content_temp = sc.next();
                            a_obj.setQuestion(content_temp, getInstructors().get(ch));
                            System.out.print("Enter Max marks: ");
                            temp = sc.nextInt();
                            a_obj.setMarks(temp,getInstructors().get(ch));
                            addAssignment(a_obj);
                        }

                        else if (temp == 2){
                            quiz q_obj = new quiz();
                            System.out.print("Enter quiz question: ");
                            content_temp = sc.next();
                            q_obj.setQuestion(content_temp,getInstructors().get(ch));
                            q_obj.setMarks(1, getInstructors().get(ch));
                            addQuiz(q_obj);
                        }

                        break;
                    case 3:
                        materialSlides();
                        materialVideos();
                        break;

                    case 4:


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
        addStudent(sobj);
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
                        materialSlides();

                        materialVideos();
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
