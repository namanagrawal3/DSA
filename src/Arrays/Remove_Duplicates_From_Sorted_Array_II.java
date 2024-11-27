package Arrays;

public class Remove_Duplicates_From_Sorted_Array_II {
    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3,4,4,4,5,5,6};
        System.out.println(twoPointerApp(arr));
        for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
        }
    }
    public static int twoPointerApp(int[] arr){
        int n=arr.length;
        int i=2,j=2;
        while(i<n){
            if(arr[i]!=arr[j-2]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
                i++;
            }
            else{
                i++;
            }
        }
        return j;
    }
}
