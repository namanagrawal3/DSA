package Wrapper_Class_n_ArrayList;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(costFun(prices, 0, 1, fee));
    }
    public static int costFun(int[] prr, int idx, int isBuy, int fee) {
        if (idx == prr.length)
            return 0;

        int maxProfit = Integer.MIN_VALUE;
        if (isBuy == 1) {
            int buy = -prr[idx] - fee + costFun(prr, idx+1, 0, fee);
            int not_buy = costFun(prr, idx+1, 1, fee);
            maxProfit = Math.max(buy, not_buy);
        }
        else {
            int sell = prr[idx] + costFun(prr, idx+1, 1, fee);
            int not_sell = costFun(prr, idx+1, 0, fee);
            maxProfit = Math.max(sell, not_sell);
        }

        return maxProfit;
    }
}