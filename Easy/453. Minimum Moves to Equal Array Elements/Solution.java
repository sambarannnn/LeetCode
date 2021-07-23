class Solution {
    public int minMoves(int[] nums) {
        //let sum of all nos in nums be sum
        //let number of required moves be totaal_moves
        //after incrementing the reqd numbers, we get an array of equal numbers , say x
        //at this point, new_sum = x*n since all elements are equal(x); n = nums.length
        // thus, we add 1 to n-1 elements for m moves
        //for each move we add 1 to n-1 elements
        //thus, for each move we add 1*(n-1) = (n-1) to the sum
        //for m moves, we add m*(n-1)
        //sum + m*(n-1) = x*n
        //also, we can find out x by observing that, every time we add 1 to n-1 elements, one of those elements is always the min number
        //so, we add +1 to the min element for m moves, then it becomes equal to x
        //x = min+1*m
        
        //sum + m*(n-1) = (min+m)*n;
        //sum + m(n-1) = min*n + m*n;
        //sum - min*n = m*n - m*(n-1);
        //sum - min*n = m(n-(n-1))
        //sum - min*n = m
        
        int m = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        m = sum - min*nums.length;
        return m;
        
//         //increasing n-1 elements by 1 has the same effect as decreasing 1 element by 1
//         //in both the cases, the difference between min and max elements remain the same
        
//         int min = Integer.MAX_VALUE;
        
//         for(int i : nums)
//             min = Math.min(i, min);
//         //now we have to make all the elements of the array equal to the min element by decrementing each value by 1 per step
        
//         //for element x to reach min, number of steps reqd will be x-min;
        
//         int total_moves = 0;
        
//         for(int i : nums) {
//             total_moves += i - min;
//         }
//         return total_moves;
    }
}
