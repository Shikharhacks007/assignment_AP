package com.company;

public class comment {
    private final String message;
    private final String name;
    private final String date;

    public comment(String name, String date, String message){
//        this.name = name.toString();
        this.name = name;
        this.date = date;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }
}
