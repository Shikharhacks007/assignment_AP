package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class course {
    private final ArrayList <student> students;
    private final ArrayList <instructor> instructors;
    private final ArrayList <assessments> assessments;
    private final ArrayList <comment> comments;
    private final ArrayList <slide> slides;
    private final ArrayList <video> videos;
    public course(){
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        assessments  = new ArrayList<>();
//        quizzes = new ArrayList<>();
        comments = new ArrayList<>();
        slides = new ArrayList<>();
        videos = new ArrayList<>();
    }

    void addInstructor(instructor obj){
        instructors.add(obj);
    }

    void addStudent(student obj){
        students.add(obj);
    }

    void addAssessments(assessments obj){
        assessments.add(obj);
//        for (int i = 0; i < getStudents().size() ; i++) {
//            getStudents().get(i).addPendingAssessments(obj);
//        }
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

    ArrayList<assessments> getAssessments(){
        return assessments;
    }

    ArrayList <comment> getComments(){
        return comments;
    }

    void addComments(comment obj){
        comments.add(obj);
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

    private void viewAssessments() {
        for (int i = 0; i < getAssessments().size(); i++) {
            if (getAssessments().get(i).getOpen()){
                if(getAssessments().get(i) instanceof assignment){
                    System.out.println("ID: " + i + " Assignment: " +
                            ((assignment) getAssessments().get(i)).getQuestion() + "Max Marks: "
                            + ((assignment) getAssessments().get(i)).getMarks());
                }
                else{
                    System.out.println("ID: " + i + " Question: " +
                            ((quiz) getAssessments().get(i)).getQuestion());
                }
            }
        }
    }

     public void start(){
        instructor iobj = new instructor("Josh");
        addInstructor(iobj);
        instructor iobj1 = new instructor("hosh");
        addInstructor(iobj1);

        student sobj = new student("Shikhs");
        addStudent(sobj);
        student sobj1 = new student("Aditya");
        addStudent(sobj1);
        student sobj2 = new student("Anis");
        addStudent(sobj2);

    }
    void menuInstructor() {
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
                            addAssessments(a_obj);
                        }

                        else if (temp == 2){
                            quiz q_obj = new quiz();
                            System.out.print("Enter quiz question: ");
                            content_temp = sc.next();
                            q_obj.setQuestion(content_temp,getInstructors().get(ch));
                            q_obj.setMarks(1, getInstructors().get(ch));
                            addAssessments(q_obj);
                        }

                        break;

                    case 3:
                        materialSlides();
                        materialVideos();
                        break;

                    case 4:
                        viewAssessments();
                        break;

                    case 5:
                        System.out.println("List of assessments");
                        for (int i = 0; i < getAssessments().size(); i++) {
                            if(getAssessments().get(i) instanceof assignment){
                                System.out.println("ID: " + i + " Assignment: " +
                                        ((assignment) getAssessments().get(i)).getQuestion() + "Max Marks: "
                                        + ((assignment) getAssessments().get(i)).getMarks());
                            }
                            else{
                                System.out.println("ID: " + i + " Question: " +
                                        ((quiz) getAssessments().get(i)).getQuestion());
                            }
                        }
                        System.out.print("Enter ID of assessment to view submissions: ");
                        temp = sc.nextInt();
                        System.out.println("Choose ID from these ungraded submissions");
                        for (int i = 0; i < getStudents().size(); i++) {
                            System.out.println(getStudents().get(i).getName());
                        }
                        int temp_student = sc.nextInt();
                        System.out.println("Submission: " + getStudents().get(temp_student).work.get(getAssessments().get(temp)).getSubmissionData());
                        System.out.println("Max Marks: " + getAssessments().get(temp).getMarks());
                        System.out.print("Marks Scored: ");
                        int marks = sc.nextInt();
                        getStudents().get(temp_student).work.get(getAssessments().get(temp)).setGrade(getInstructors().get(ch),marks);
                        getStudents().get(temp_student).work.get(getAssessments().get(temp)).setGradedBy(getInstructors().get(ch),getInstructors().get(ch).getName());
                        break;

                    case 6:
                        System.out.println("List of Open Assessments");
                        if (getAssessments().size()>=1){
                            viewAssessments();
                            System.out.print("Enter id of assignment to close: ");
                            temp = sc.nextInt();
                            getAssessments().get(temp).setOpen();
                        }
                        else{
                            System.out.println("Nothing is open");
                        }
                        break;

                    case 7:
                        for (int i = 0; i < getComments().size() ; i++) {
                            System.out.println(getComments().get(i).getMessage() + " - " +  getComments().get(i).getName());
                            System.out.println(getComments().get(i).getDate());
                        }
                        break;

                    case 8:
                        System.out.print("Enter comment: ");
                        content_temp = sc.nextLine();
                        String date = "34";
                        comment cobj = new comment(getInstructors().get(ch).getName(),date,content_temp );
                        addComments(cobj);
                }
                System.out.println();
                System.out.println("Welcome: " + getInstructors().get(ch).getName());
                System.out.println("instructors menu");
                selection = sc.nextInt();
            }
        }
    }

    void menuStudent() {
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
                        viewAssessments();
                        break;

                    case 3:
                        for (int i = 0; i < getAssessments().size(); i++) {
                            if (!getStudents().get(ch).work.containsKey(getAssessments().get(i)) && getAssessments().get(i).getOpen()){
                                if(getAssessments().get(i) instanceof assignment){
                                    System.out.println("ID: " + i + " Assignment: " +
                                            ((assignment) getAssessments().get(i)).getQuestion() + "Max Marks: "
                                            + ((assignment) getAssessments().get(i)).getMarks());
                                }
                                else{
                                    System.out.println("ID: " + i + " Question: " +
                                            ((quiz) getAssessments().get(i)).getQuestion());
                                }

                            }
                        }
                        System.out.print("Enter ID of the assessment: ");
                        int temp = sc.nextInt();
                        String content_temp;
                        submissions submissions_obj = new submissions();
                        if (getAssessments().get(temp) instanceof assignment){
                            System.out.print("Enter filename of assignment");
                            content_temp = sc.next();
                            // check extension validity
                            if (false){
                                while (true){
                                    System.out.println("Enter again with right extension");
                                    content_temp = sc.next();
                                }
                            }
                            submissions_obj.setSubmissionFile(content_temp);
                            getStudents().get(ch).setSubmissionsDone(getAssessments().get(temp),submissions_obj);
                        }
                        else{
                            System.out.print(getAssessments().get(temp).getQuestion() + ": ");
                            content_temp = sc.next();
                            // check extension validity
                            submissions_obj.setSubmissionFile(content_temp);
                            getStudents().get(ch).setSubmissionsDone(getAssessments().get(temp),submissions_obj);
                        }
                        break;

                    case 4:
                        System.out.println("Graded submissions");
                        for (Map.Entry<assessments,submissions> m : getStudents().get(ch).work.entrySet()){
                            submissions sub_obj = m.getValue();
                            if(sub_obj.getGraded()){
                                System.out.println("Submission: " + sub_obj.getSubmissionData());
                                System.out.println("Marks Scored: " + sub_obj.getGrade());
                                System.out.println("Graded By: " + sub_obj.getGradedBy());
                            }
                        }

                        System.out.println("Ungraded submissions");
                        for (Map.Entry<assessments,submissions> m : getStudents().get(ch).work.entrySet()){
                            submissions sub_obj = m.getValue();
                            if(!sub_obj.getGraded()){
                                System.out.println("Submission: " + sub_obj.getSubmissionData());
                            }
                        }
                        break;

                    case 5:
                        for (int i = 0; i < getComments().size() ; i++) {
                            System.out.println(getComments().get(i).getMessage() + " - " +  getComments().get(i).getName());
                            System.out.println(getComments().get(i).getDate());
                        }
                        break;
                    case 6:
                        System.out.print("Enter comment: ");
                        content_temp = sc.next();
                        String date = "34";
                        comment cobj = new comment(getStudents().get(ch).getName(),date,content_temp );
                        addComments(cobj);

                }

                System.out.println();
                System.out.println("Welcome: " + getStudents().get(ch).getName());
                System.out.println("Student menu");
                selection = sc.nextInt();
            }
        }
    }
}
