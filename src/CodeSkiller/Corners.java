package CodeSkiller;

import java.util.ArrayList;

public class Corners {
    public static void main(String[] args) {

        //   https://codeskiller.codingblocks.com/problems/2937

        int[] arr = {2,4,1,5,3,0};
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int maxLoopSize = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int current = i;
                ArrayList<Integer> l = new ArrayList<>();
                while(!visited[current]){
                    visited[current] = true;
                    l.add(current);
                    current = arr[current];
                }
                maxLoopSize = Math.max(maxLoopSize,l.size());
            }
        }
        System.out.println(maxLoopSize);
    }
}
