package Patterns;

import java.util.Scanner;

public class Pattern_32 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern32(sc.nextInt());

    }

    public static void pattern32(int row) {
        int i=1;
        int count=1;
        int val=1;
        while(i<=2*row-1){
            int j=1;
            while(j<=count){
                if(j%2==0)
                    System.out.print("* ");
                else
                    System.out.print(val+" ");
                j++;
            }
            if(i<row){
                count+=2;
                val++;
            }
            else{
                count-=2;
                val--;
            }
            i++;
            System.out.println();
        }

    }
}
