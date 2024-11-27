package Patterns;

import java.util.Scanner;

public class Pattern_28 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern28(sc.nextInt());

    }

    public static void pattern28(int row) {
        int i=1;
        int space=row-1;
        int count=1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print(" \t");
                k++;
            }
            int digit=i;
            int j=1;
            while(j<=count){
                System.out.print(digit+"\t");
                if(j<count/2+1)
                    digit++;
                else
                    digit--;
                j++;
            }
            i++;
            space--;
            count+=2;
            System.out.println();
        }
    }
}
