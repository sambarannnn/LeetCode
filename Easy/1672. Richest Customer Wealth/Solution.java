class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int[] customer : accounts) {
            int curr_wealth = 0;
            for(int money_in_account : customer) {
                curr_wealth += money_in_account;
            }
            maxWealth = Math.max(maxWealth, curr_wealth);
        }
        return maxWealth;
    }
}
