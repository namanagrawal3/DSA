package Patterns;

import java.util.Scanner;

public class Pattern_29 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern29(sc.nextInt());

    }

    public static void pattern29(int row) {
        int i=1;
        int space=row-1;
        int count=1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            int j=1;
            while(j<=count){
                if(j==1 || j==count)
                    System.out.print(i+" ");
                else
                    System.out.print(0+" ");
                j++;
            }
            i++;
            space--;
            count+=2;
            System.out.println();
        }

    }
}
