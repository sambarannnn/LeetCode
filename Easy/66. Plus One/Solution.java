class Solution {
    public int[] plusOne(int[] digits) {
        /*
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //in case entire input was 9999... 
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
        */
        //CAN BE USED TO ADD ANY GIVEN NUMBER
        int n = digits.length;
        int carry = 0;
        int tobeadded = 1;//from question
        int sum;
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1)
                sum = digits[i] + tobeadded;
            else
                sum = digits[i] + carry;
            digits[i] = (sum) % 10 ;
            carry = sum / 10;
            if(carry == 0)
                return digits;
        }
        //in case entire input was 9999... 
        int[] newNumber = new int [n+1];
        newNumber[0] = carry;
        
        return newNumber;

    }
}
