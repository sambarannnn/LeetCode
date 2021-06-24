class Solution {
    public int myAtoi(String s) {
        //take off all leading/tailing spaces
        s = s.trim();
        //if string is null
        if (s == null || s.length() == 0) return 0;
        int sign = 1;
        int i = 0;
        if(s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if(s.charAt(0) == '+')
            i++;
        
        long sum = 0;
        for (; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i)))
                break;
            sum = sum * 10 + s.charAt(i) - '0';//moves from ones to tens to ....bby multiplying w 10
            if (sign == 1 && sum > Integer.MAX_VALUE)//it becomes more than int value
			    return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)//it becomes lesser than int value
			    return Integer.MIN_VALUE;
        }
        return (int) sum*sign;
    }
}
