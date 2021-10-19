package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    void viewComments (user uobj){
        uobj.view_comments(comments);
    }

    void addComments(comment obj, user uobj){
        uobj.add_comments(comments, obj);
    }

    ArrayList<slide> getSlides(){
        return slides;
    }

    ArrayList<video> getVideos(){return videos;}

    public String dateSetter(){
        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS zzz yyyy");
        Date date = new Date();
        return df.format(date);
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

    private boolean checkFile(String content_temp, user obj) {
        String[] arr = content_temp.split("[.]", 0);
        if (obj instanceof instructor){
            if(arr.length == 2){
                return arr[1].equals("mp4");
            }
            else{
                return false;
            }
        }
        else if (obj instanceof student){
            if(arr.length == 2){
                return arr[1].equals("zip");
            }
            else{
                return false;
            }
        }
        return false;
    } //issue here

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

    void menuInstructor() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            getInstructors().get(ch).menu();
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
                            content_temp = br.readLine();
                            slide_obj.setTitle(content_temp);
                            System.out.print("Enter number of slides: ");
                            temp = sc.nextInt();
                            slide_obj.setCount(temp);
                            System.out.println("Enter content of slides");
                            for (int i = 1; i <= temp; i++) {
                                System.out.print("Content of slide " + i + ":");
                                content_temp = br.readLine();
                                slide_obj.getSlides().add(content_temp);
                            }
                            slide_obj.setDate(dateSetter());
                            slide_obj.setUploadedBy(getInstructors().get(ch).getName());
                            addSlide(slide_obj);
                        }

                        else if (temp == 2){
                            video video_obj = new video();
                            System.out.print("Enter topic of video: ");
                            content_temp = br.readLine();
                            video_obj.setTitle(content_temp);
                            System.out.print("Enter filename of video: ");
                            content_temp = sc.next();

                            //checker of the validity
                            if (!checkFile(content_temp,getInstructors().get(ch))){
                                while(!checkFile(content_temp,getInstructors().get(ch))){
                                    System.out.println("Enter again with right extension");
                                    content_temp = br.readLine();
                                }
                                video_obj.setVideoFile(content_temp);
                                video_obj.setDate(dateSetter());
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
                            content_temp = br.readLine();
                            a_obj.setQuestion(content_temp, getInstructors().get(ch));
                            System.out.print("Enter Max marks: ");
                            temp = sc.nextInt();
                            a_obj.setMarks(temp,getInstructors().get(ch));
                            addAssessments(a_obj);
                        }

                        else if (temp == 2){
                            quiz q_obj = new quiz();
                            System.out.print("Enter quiz question: ");
                            content_temp = br.readLine();
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
                            System.out.println(i + getStudents().get(i).getName());
                        }
                        int temp_student = sc.nextInt();
                        if (!getStudents().get(temp_student).work.isEmpty()){
                            System.out.println("Submission: " + getStudents().get(temp_student).work.get(getAssessments().get(temp)).getSubmissionData());
                            System.out.println("Max Marks: " + getAssessments().get(temp).getMarks());
                            System.out.print("Marks Scored: ");
                            int marks = sc.nextInt();
                            getStudents().get(temp_student).work.get(getAssessments().get(temp)).setGrade(getInstructors().get(ch),marks);
                            getStudents().get(temp_student).work.get(getAssessments().get(temp)).setGradedBy(getInstructors().get(ch),getInstructors().get(ch).getName());
                        }

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
                        viewComments(getInstructors().get(ch));
                        break;

                    case 8:
                        System.out.print("Enter comment: ");
                        content_temp = br.readLine();
                        comment cobj = new comment(getInstructors().get(ch).getName(),dateSetter(),content_temp );
                        addComments(cobj,getInstructors().get(ch));
                }
                System.out.println();
                System.out.println("Welcome: " + getInstructors().get(ch).getName());
                System.out.println("instructors menu");
                getInstructors().get(ch).menu();
                selection = sc.nextInt();
            }
        }
    }

    void menuStudent() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            getStudents().get(ch).menu();
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
                        int statement = 0;
                        for (int i = 0; i < getAssessments().size(); i++) {
                            if (!getStudents().get(ch).work.containsKey(getAssessments().get(i)) && getAssessments().get(i).getOpen()){
                                if(getAssessments().get(i) instanceof assignment){
                                    System.out.println("ID: " + i + " Assignment: " +
                                            ((assignment) getAssessments().get(i)).getQuestion() + "Max Marks: "
                                            + ((assignment) getAssessments().get(i)).getMarks());
                                    statement++;
                                }
                                else{
                                    System.out.println("ID: " + i + " Question: " +
                                            ((quiz) getAssessments().get(i)).getQuestion());
                                    statement++;
                                }

                            }
                        }
                        String content_temp;
                        if (statement>0){
                            System.out.print("Enter ID of the assessment: ");
                            int temp = sc.nextInt();
                            submissions submissions_obj = new submissions();
                            if (getAssessments().get(temp) instanceof assignment){
                                System.out.print("Enter filename of assignment");
                                content_temp = sc.next();

                                // check extension validity
                                if (!checkFile(content_temp,getStudents().get(ch))){
                                    while (checkFile(content_temp,getStudents().get(ch))){
                                        System.out.println("Enter again with right extension");
                                        content_temp = br.readLine();
                                    }
                                }
                                submissions_obj.setSubmissionFile(content_temp);
                                getStudents().get(ch).setSubmissionsDone(getAssessments().get(temp),submissions_obj);
                            }
                            else{
                                System.out.print(getAssessments().get(temp).getQuestion() + ": ");
                                content_temp = br.readLine();
                                // check extension validity
                                submissions_obj.setSubmissionFile(content_temp);
                                getStudents().get(ch).setSubmissionsDone(getAssessments().get(temp),submissions_obj);
                            }
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
                        viewComments(getStudents().get(ch));
                        break;

                    case 6:
                        System.out.print("Enter comment: ");
                        content_temp = br.readLine();
                        comment cobj = new comment(getStudents().get(ch).getName(),dateSetter(),content_temp );
                        addComments(cobj, getStudents().get(ch));
                        break;

                }

                System.out.println();
                System.out.println("Welcome: " + getStudents().get(ch).getName());
                System.out.println("Student menu");
                getStudents().get(ch).menu();
                selection = sc.nextInt();
            }
        }
    }
}
