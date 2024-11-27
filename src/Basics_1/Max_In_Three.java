package Basics_1;

import java.util.Scanner;

public class Max_In_Three {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
//        if(a>=b){
//            if(a>=c)
//                System.out.println(a+" is greater");
//            else
//                System.out.println(c+" is greater");
//        }
//        else{
//            if(b>=c)
//                System.out.println(b+" is greater");
//            else
//                System.out.println(c+" is greater");
//        }
        if(a>=b && a>=c)
            System.out.println(a+" is greater");
        else if (b>=a && b>=c)
            System.out.println(b+" is greater");
        else
            System.out.println(c+" is greater");
    }
}
