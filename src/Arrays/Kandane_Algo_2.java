package Arrays;

import java.util.Scanner;

public class Kandane_Algo_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        maxSumSubarray(arr);
    }
    public static void maxSumSubarray(int[] arr){
        int max=Integer.MIN_VALUE;
        int sum=0;
        int fist_index=-1,last_index=-1,start=-1;
        for(int i=0;i<arr.length;i++){
            if(sum==0)
                start=i;
            sum+=arr[i];
            if(sum>max){
                max=sum;
                fist_index=start;
                last_index=i;
            }
            if(sum<0)
                sum=0;
        }
        System.out.println("Sum is:"+max);
        for(int i=fist_index;i<=last_index;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
