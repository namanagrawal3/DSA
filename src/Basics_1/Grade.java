package Basics_1;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int grade=sc.nextInt();
        if(grade>=75)
            System.out.println("Grade A");
        else if(grade>=65 && grade<75)
            System.out.println("Grade B");
        else if(grade>=55 && grade<65)
            System.out.println("Grade C");
        else if(grade>=45 && grade<55)
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
}
