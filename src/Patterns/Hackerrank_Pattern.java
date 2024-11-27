package Patterns;

import java.util.Scanner;

public class Hackerrank_Pattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        patternType1(n);
        System.out.println();
        patternType2(n);
    }
    public static void patternType1(int n){
        int i=1;
        int count=2*n-1;
        while(i<=2*n-1){
            int j=1;
            while(j<=count){
                int val=n-Math.min(Math.min(j-1,count-j),Math.min(i-1,count-i));
                System.out.print(val+" ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
    public static void patternType2(int n){
        int i=1;
        int count=2*n-1;
        while(i<=2*n-1){
            int j=1;
            while(j<=count){
                int val=Math.min(Math.min(j-1,count-j),Math.min(i-1,count-i));
                System.out.print(val+" ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
