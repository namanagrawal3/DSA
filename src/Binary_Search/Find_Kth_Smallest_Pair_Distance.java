package Binary_Search;

import java.util.Arrays;

public class Find_Kth_Smallest_Pair_Distance {
    public static void main(String[] args) {
        int[] arr = {1,6,1};
        int k = 3;
        int n = arr.length;
        Arrays.sort(arr);
        int si = 0;
        int ei = arr[n-1]-arr[0];
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(isPossible(mid,arr,k))
                ei = mid-1;
            else
                si = mid+1;
        }
        System.out.println(si);
    }
    public static boolean isPossible(int dist,int[] arr,int k){
        int count = 0;
        int si = 0;
        int ei = 1;
        while(ei<arr.length){
            while(arr[ei]-arr[si]>dist && si<=ei){
                si++;
            }
            count += ei-si;
            if(count >= k)
                return true;
            ei++;
        }
        return false;
    }
}
