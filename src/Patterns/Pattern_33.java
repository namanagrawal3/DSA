package Patterns;

import java.util.Scanner;

public class Pattern_33 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern33(sc.nextInt());
    }

    public static void pattern33(int row) {
        int i=1;
        int space=row-1;
        int count=1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            int digit=row+1-i;
            int j=1;
            while(j<=count){
                if(digit==10)
                    System.out.print(0+" ");
                else
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
