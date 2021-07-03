class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        //if numerator is 0
        if(numerator == 0)
            return "0";
        
        StringBuilder result = new StringBuilder();
        
        //for sign
        //if both signs are same, result will be positive
        //if both signs are different result will be negative
        
        //no need to append positive sign
        // if(numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0)
        //     result.append("+");
        if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
            result.append("-");
        
        //converting numerator and denominator to longs to handle integer over or underflow
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        
        //integer part
        result.append(n/d);//adds the quotient to the result;
        //remainder can be found using modulo, next numerator will be this value
        n = n % d;
        //at this point if, n is 0, we have found our answer and we can return;
        if(n == 0)
            return result.toString();
        
        
        //decimal part
        result.append(".");
        
        //we will store value of each remainder along with it's corresponding quotient's position on a map
        //at any point, if a remainder repeats, we will access it's previously mapped qotient's position and put opening bracket "(" behind it, and append closing branket to result and return
        
        //remainder, corresponding quotient position
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        //mapping existing remainder remainder
        map.put(n, result.length());//result.length() will give the last position, pos just after the recent quotient
        
        while(n != 0) {
            n = n * 10;
            result.append(n / d);
            n = n % d;
            
            //now check if this remainder already exists
            if(map.containsKey(n)) {
                result.insert(map.get(n), "(");//inserts at corresponding quotient
                result.append(")");
                break;
            }
            map.put(n, result.length());
        }
        return result.toString();
    }
}
