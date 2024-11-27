package CodeSkiller;

import java.util.Arrays;

public class Trip_in_a_Bus {
    public static void main(String[] args) {

        // https://codeskiller.codingblocks.com/problems/4093

        int[] arr = {1,3,2};
        int trips = 5;
        int n = arr.length;
        Arrays.sort(arr);
        int si = 0;
        int ei = arr[n-1]*trips;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(isPossible(mid,arr,trips))
                ei = mid-1;
            else
                si = mid+1;
        }
        System.out.println(si);
    }
    public static boolean isPossible(int t,int[] arr,int trips){
        int i = 0;
        int mins = 0;
        int ans = 0;
        while(i<arr.length){
            if(mins+arr[i] <= t){
                mins += arr[i];
                ans++;
                if(ans == trips)
                    return true;
            }
            else{
                i++;
                mins = 0;
            }
        }
        return false;
    }
}
