class Solution {
    public int reverse(int x) {
        //popping each digit from the end by %10
        //making input number shorter from the right by doing /10
        //pushing this popped digit into the reversed number
        int reversed = 0;
        int pop;
        while(x != 0) {
            pop = x%10;
            x /= 10;
            //check if push operation can be performed or not
            //A signed 32-bit integer lies in the range [-2147483648 to 2147483647].
            
            if(reversed > 2147483647/10 || (reversed == 2147483647/10 && pop > 7))
                return 0;
            if(reversed < -2147483648/10 || (reversed == -2147483648/10 && pop < -8))
                return 0;
            //this moves the digits one place to the left and 
            //leaves 0 at the end for new digit to be added
            reversed = (reversed * 10) + pop;
        }
        return reversed;
    }
}
