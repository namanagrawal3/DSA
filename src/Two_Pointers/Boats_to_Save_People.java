package Two_Pointers;

import java.util.Arrays;

public class Boats_to_Save_People {
    public static void main(String[] args) {
        int[] people = {5,1,4,2};
        int limit = 6;

        // This problem can not be solved by the 'Binary Search' technique after sorting the array.
        // It will fail at the given testcase, so will we will use 'Two Pointers' approach here.

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int boat = 0;
        while(left<=right){
            if(people[left]+people[right] <= limit){
                boat++;
                left++;
                right--;
            }
            else{
                boat++;
                right--;
            }
        }
        System.out.println(boat);
    }
}
