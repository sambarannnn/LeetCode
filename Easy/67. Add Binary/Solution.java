class Solution {
    private static int BASE = 2;//given in question
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int sum = 0;
        int carry = 0;
        
        while (i >= 0 || j >= 0){
            //count carry from previous iteration
            sum = carry;
            
            if (i >= 0) 
                sum += a.charAt(i--) - '0';//ascii to decimal
            if (j >= 0) 
                sum += b.charAt(j--)-'0';//ascii to decimal
            
            carry = sum / BASE;
            sb.append(sum % BASE);
        }
        
        if (carry != 0) 
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}


