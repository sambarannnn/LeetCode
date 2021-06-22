class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            //count as profit if price went up in given day
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;

    }
}
