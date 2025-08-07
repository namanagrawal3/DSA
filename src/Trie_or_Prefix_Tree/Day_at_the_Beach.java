package Trie_or_Prefix_Tree;

public class Day_at_the_Beach {
    public static void main(String[] args) {
        // Leetcode 915:     Partition Array into Disjoint Intervals

        int[] h = {17, 18, 18, 19, 17, 100, 500, 100, 100};  // codeforces
        int n = h.length;

        int[] suffMin = new int[n];                          // stores the min element to the right end
        suffMin[n-1] = h[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i+1], h[i]);
        }

        int leftMax = Integer.MIN_VALUE;                    // stores the max element to the left end
        int blocks = 0;

        for (int i = 0; i < n-1; i++) {
            leftMax = Math.max(leftMax, h[i]);
            if (leftMax <= suffMin[i+1])
                blocks++;
        }

        System.out.println(blocks + 1);
    }
}
