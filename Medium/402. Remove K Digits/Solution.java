class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();//use like a stack
        
        for(char c : num.toCharArray()) {
            int n = Character.getNumericValue(c);
            
            //if k is still left, stack is not empty and stack top is bigger than current element, stacktop is a peak
            while(k > 0 && sb.length() > 0 && Character.getNumericValue(sb.charAt(sb.length()-1)) > n) {
                sb.deleteCharAt(sb.length()-1);//stack popping
                k--;
            }
            if(sb.length() == 0 && n == 0)//ignoring leading zeroes
                continue;
            sb.append(n);//stack pushing
        }
        
        //in case k is not exhausted
        while(k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);//stack popping
            k--;
        }
        if(sb.length() == 0)
            return "0";
        return sb.toString();
    }
}
