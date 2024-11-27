package Recursion;

public class reverse_an_array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverseArray(arr,0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void reverseArray(int[] arr,int idx){
        int n = arr.length;                                                 // Tail Recursion
        if(idx == n/2)
            return;
        swap(arr,idx,n-1-idx);
        reverseArray(arr,idx+1);
    }
    public static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
