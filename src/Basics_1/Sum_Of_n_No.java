package Basics_1;

import java.util.Scanner;

public class Sum_Of_n_No {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int i=1;
        while(i<=n){
            sum+=i;             // OR n(n+1)/2
            i++;
        }
        System.out.printf("Sum of first %d natural numbers is:%d",n,sum);
    }
}
