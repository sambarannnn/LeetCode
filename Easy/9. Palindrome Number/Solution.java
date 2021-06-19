class Solution {
    public boolean isPalindrome(int x) {
        /*StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb = sb.reverse();
        if(Integer.toString(x).equals(sb.toString()))
            return true;
        return false;*/
        
        //0(log(n)) approach
        //if x is -ve
        //OR
        //if last digit is zero, then first digit has to be zero i.e., ZERO(0) itself
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        //lets invert half of the number and compare it with the remaining half. If that is equal then its a palindrome
        int reverse = 0;
        //Since we divided the number by 10, and multiplied the reversed number by 10, when the original number is less than the reversed number, it means we've processed half of the number digits
        //until half
        while(x > reverse) {
            reverse = reverse*10 + x%10;//reverse*10 shifts digits to left and leaves 0 at end where we add last digit of x (x%10).
            x = x/10;
        }
        //Now, reverse has half the numbers
        //if input was odd no of digits then reverse has the extra middle digit as well which won't count
        if(x == reverse || x == reverse/10)//even case || odd case
            return true;
        return false;
    }
}
