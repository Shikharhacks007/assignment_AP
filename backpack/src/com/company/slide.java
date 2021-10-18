package com.company;

import java.util.ArrayList;

public class slide implements materials {
    private String title;
    private String uploadedBy;
    private  String date;
    private int count;
    private ArrayList <String> slides;

    public slide(){
        slides  = new ArrayList<>();
    }

    @Override
    public void setTitle(String a){
        title = a;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public void setDate(String a){
        date = a;
    }

    @Override
    public String getDate(){
        return date;
    }

    @Override
    public void setUploadedBy(String a){
        uploadedBy = a;
    }

    @Override
    public String getUploadedBy(){
        return uploadedBy;
    }

    public ArrayList<String> getSlides(){
        return slides;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setSlides(String obj) {
        slides.add(obj);
    }

}
