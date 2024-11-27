package Patterns;

import java.util.Scanner;

public class Pattern_27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern27(sc.nextInt());

    }

    public static void pattern27(int row) {
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
            int digit=1;
            while(j<=count){
                System.out.print(digit+" ");
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
