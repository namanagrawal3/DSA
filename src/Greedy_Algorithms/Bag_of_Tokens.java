package Greedy_Algorithms;

import java.util.Arrays;

public class Bag_of_Tokens {
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int power = 200;
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int i=0,j=tokens.length-1;
        while(i<=j){
            if(power >= tokens[i]){
                power -= tokens[i];
                score++;
                i++;
            }
            else if(score >= 1){
                score--;
                power += tokens[j];
                j--;
            }
            else
                break;
            maxScore = Math.max(maxScore,score);
        }
        System.out.println(maxScore);
    }
}
