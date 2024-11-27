package Recursion;

public class first_occurence {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,4,3,4,7};
        int item = 4;
        System.out.println(findOccur(arr,item,0));
    }
    public static int findOccur(int[] arr,int item,int idx){
        if(idx == arr.length)
            return -1;
        if(arr[idx] == item)
            return idx;
        return findOccur(arr,item,idx+1);
    }
}
