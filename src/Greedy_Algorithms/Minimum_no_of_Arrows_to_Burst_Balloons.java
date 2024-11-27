package Greedy_Algorithms;

import java.util.Arrays;

public class Minimum_no_of_Arrows_to_Burst_Balloons {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(points,(a, b)->(Integer.compare(a[0],b[0])));
//        for(int i=0;i< points.length;i++){
//            for(int j=0;j<2;j++){
//                System.out.print(points[i][j]+" ");
//            }
//            System.out.println();
//        }
        int count = 1;
        int prev_start = points[0][0];
        int prev_end = points[0][1];
        for(int i=1;i<points.length;i++){
            int curr_start = points[i][0];
            int curr_end = points[i][1];
            if(curr_start > prev_end){
                count++;
                prev_start = curr_start;
                prev_end = curr_end;
            }
            else{
                prev_start = Math.max(prev_start,curr_start);
                prev_end = Math.min(prev_end,curr_end);
            }
        }
        System.out.println(count);
    }
}
