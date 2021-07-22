class Solution {
      public int arrangeCoins(int n) {
          // the final answer will be 1 + 2 + 3 + .... kthlevel <= n
          // k*(k+1)/2 <= n
          //find tha value of such a k between 1 and n
        long left = 1, right = n;
        long levelk;
        long curr;
        
        while (left <= right) {
          levelk = left + (right - left) / 2;
          curr = levelk * (levelk + 1) / 2;

          if (curr == n) return (int)levelk;

          if (n < curr) {
            right = levelk - 1;
          } else {
            left =levelk + 1;
          }
        }
        return (int)right;//in case we don't find exact equal value
    }
}
// class Solution {
//     public int arrangeCoins(int n) {
//         int levelCount = 0;
//         int level = 1;
//         while(n>=0){            
//             n = n - level;//subtract max coins for this level
//             levelCount++;
//             level++;
//         }
//         return levelCount-1;
//     }
// }
