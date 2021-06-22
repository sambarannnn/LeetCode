class Solution {
    public int maxProfit(int[] prices) {
        
        /*
        int maxprofit = 0;
        for(int i = 1; i < prices.length; i++) {
            //count as profit if price went up in given day
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
        */
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            
            //find first min price to buy
            while (i < N && prices[i + 1] <= prices[i]) 
                i++;
            buy = prices[i];
            
            //find first max price to sell
            while (i < N && prices[i + 1] > prices[i]) 
                i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;

    }
}
