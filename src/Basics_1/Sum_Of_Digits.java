package Basics_1;

import java.util.Scanner;

public class Sum_Of_Digits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int N=n;
        int sum=0;
        while(n!=0){
            sum += n%10;
            n/=10;
        }
        System.out.printf("Sum of digits of %d is %d.",N,sum);
    }
}
