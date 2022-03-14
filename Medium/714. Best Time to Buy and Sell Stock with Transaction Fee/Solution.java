class Solution {
    public int maxProfit(int[] prices, int fee) {
        int boughtState = -prices[0];
        int soldState = 0;
        for(int i = 1; i < prices.length; i++) {
            int temp = boughtState;
            boughtState = Math.max(boughtState, soldState - prices[i]);
            soldState = Math.max(soldState, temp + prices[i] - fee);
        }
        return soldState;
    }
}
