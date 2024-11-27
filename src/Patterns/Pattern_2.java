package Patterns;

import java.util.Scanner;

public class Pattern_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern2(sc.nextInt());

    }

    public static void pattern2(int row) {
        int i=1;
        int star=1;
        while(i<=row){
            int j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            i++;
            star++;
            System.out.println();
        }

    }
}
