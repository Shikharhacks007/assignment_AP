package com.company;

public class slide implements materials {
    private String title;
    private String uploadedBy;
    private  String date;
    public slide(){
        title ="";
        uploadedBy="";
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
}
