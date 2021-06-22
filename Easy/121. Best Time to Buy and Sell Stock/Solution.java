class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            //check if this is minimum price
            if(minprice > prices[i]) {
                minprice = prices[i];
                continue;
                //if this is min price, then no need to calculate profit on this, just move on to next price w new minvalue in store
            }
            int curr_profit = prices[i] - minprice;
            maxprofit = Math.max(maxprofit, curr_profit);
        }
        return maxprofit;
    }
}
