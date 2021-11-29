package com.company;

public class softToy implements Cloneable {
    private final String name;

    public softToy(String name){
        this.name = name;
    }

    public softToy clone(Object temp){
        if ( temp instanceof tile){
            try
            {
                return (softToy) super.clone();
            }
            catch (CloneNotSupportedException e){
                System.out.println("exception");
                return null; //null pointer exception
            }
        }
        else
            return null;
    }

    public String getName() {
        return name;
    }
}
