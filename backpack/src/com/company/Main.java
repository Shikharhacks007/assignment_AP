package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Backpack");
        System.out.println("1. Enter as Instructor");
        System.out.println("2. Enter as Student");
        System.out.println("3. Exit");
        ch = sc.nextInt();
        course c = new course();
        while (ch != 3 ){
            switch (ch) {
                case 1 -> c.menuInstructor();
                case 2 -> c.menuStudent();
                default -> System.out.println("wrong option try again");
            }
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as Instructor");
            System.out.println("2. Enter as Student");
            System.out.println("3. Exit");
            ch = sc.nextInt();
        }
    }
}
