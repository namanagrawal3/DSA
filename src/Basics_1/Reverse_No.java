package Basics_1;

import java.util.Scanner;

public class Reverse_No {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int N=n;
        while(n!=0){
            int rem=n%10;
            sum = sum*10 + rem;
            n/=10;
        }
        System.out.printf("Reverse of %d is %d.",N,sum);
    }
}
