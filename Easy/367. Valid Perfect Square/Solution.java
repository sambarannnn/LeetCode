class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            //by not checking if mid*mid == num, we avoid integer overflow
            int res = num/mid;//perfect square should be like : res=mid for res*mid = num if res = num/mid
            int remainder = num%mid;//make sure it didn't leave a remainder
            if(res == mid && remainder == 0)//checking square
                return true;
            if(res < mid)//mid is big, go to left to decrease
                end = mid-1;
            else//(res > mid)//mid is small, go to right to increase
                start = mid+1;
        }
        return false;
    }
}
