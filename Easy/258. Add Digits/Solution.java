class Solution {
    public int addDigits(int num) {
        int curr = num;
        int sum = 0;
        while(true) {
            //adding all digits
            while(curr != 0) {
                sum += curr%10;
                curr /= 10;
            }
            //checking if current sum is a one digit number
            if(sum/10 == 0)
                return sum;
            //resetting curr and sum values
            else {
                curr = sum;
                sum = 0;
            }
        }
    }
    public int TRICKaddDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
