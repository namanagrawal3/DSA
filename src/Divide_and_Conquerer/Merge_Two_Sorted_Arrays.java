package Divide_and_Conquerer;

public class Merge_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,11,19,20,23};
        int[] brr = {1,3,5,6,8,9,10};
        int[] ans = mergeSort(arr,brr);
        for(int k=0;k<ans.length;k++){
            System.out.print(ans[k]+" ");
        }
    }
    public static int[] mergeSort(int[] arr,int[] brr){
        int n = arr.length;
        int m = brr.length;
        int[] ans = new int[n+m];
        int i = 0;
        int j = 0;
        int idx = 0;
        while(i<n && j<m){
            if(arr[i] <= brr[j]){
                ans[idx++] = arr[i];
                i++;
            }
            else{
                ans[idx++] = brr[j];
                j++;
            }
        }
        while(i<n){
            ans[idx++] = arr[i];
            i++;
        }
        while(j<m){
            ans[idx++] = brr[j];
            j++;
        }
        return ans;
    }
}
