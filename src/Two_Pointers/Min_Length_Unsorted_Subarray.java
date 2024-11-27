package Two_Pointers;

import java.util.Arrays;

public class Min_Length_Unsorted_Subarray {
    public static void main(String[] args) {
        int[] arr = {10,12,20,30,25,40,32,31,35,50,60};
        //int[] arr = {1,2,3,4,7,9};
        //int[] arr = {0,1,15,25,6,7,30,40,50};
        System.out.println(firstApproach(arr));
        System.out.println(secondApproach(arr));
    }
    public static int firstApproach(int[] arr){
        int n=arr.length;
        int s=-1,e=-1;
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        for(int i=0;i<n;i++){
            if(arr[i]!=temp[i]){
                s=i;
                break;
            }
        }
        if(s==-1)
            return 0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]!=temp[i]){
                e=i;
                break;
            }
        }
        for(int i=s;i<=e;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return e-s+1;
    }
    public static int secondApproach(int[] arr){
        int n=arr.length;
        int s=-1,e=-1;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                s=i;
                break;
            }
        }
        if(s==-1)
            return 0;
        for(int i=n-1;i>0;i--){
            if(arr[i]<arr[i-1]){
                e=i;
                break;
            }
        }
        int max=arr[s],min=arr[s];
        for(int i=s;i<=e;i++){
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        for(int i=0;i<s;i++){
            if(arr[i]>min){
                s=i;
                break;
            }
        }
        for(int i=e+1;i<n;i++){
            if(arr[i]<max){
                e=i;
                break;
            }
        }
        for(int i=s;i<=e;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return e-s+1;
    }
}
