package com.company;
import java.io.*;
import java.io.IOException;

public class cheatSheet {
    public void cheat(){
        try {
            File myObj = new File("cheatSheet.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            try {
                FileWriter myWriter = new FileWriter("cheatSheet.txt");
                myWriter.write("""
                        ************************************************
                        ************************************************
                        ************************************************
                        *************d**********************************
                        **************i*********************************
                        ****************c*******************************
                        ******************ebiased*****************************
                        Enter when prompted for the first dice roll""");
                myWriter.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int[] way(){
        return new int[]{1,2,2,1};
    }
}
