class Solution {
    public int arrangeCoins(int n) {
        int levelCount = 0;
        int level = 1;
        while(n>=0){            
            n = n - level;//subtract max coins for this level
            levelCount++;
            level++;
        }
        return levelCount-1;
    }
}
