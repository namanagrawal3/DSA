package CodeSkiller;

public class Reverse_Subarray_To_MAximize_Array_Value {
    public static void main(String[] args) {

        // https://codeskiller.codingblocks.com/problems/4037

        int[] arr = {2,3,1,5,4};
        int n = arr.length;
        int max = valueOfArray(arr);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                reverseArray(arr,i,j);
                max = Math.max(max,valueOfArray(arr));
                reverseArray(arr,i,j);
            }
        }
        System.out.println(max);
    }
    public static int valueOfArray(int[] arr){
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            sum += Math.abs(arr[i]-arr[i+1]);
        }
        return sum;
    }
    public static void reverseArray(int[] arr,int left,int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
