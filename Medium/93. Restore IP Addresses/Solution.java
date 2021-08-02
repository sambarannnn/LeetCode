class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        backtrack(0, "", res, s);
        return res;
    }
    
    private void backtrack(int index, String curr, List<String> res, String s) {
        if(index == 4) {//we have overshot
            
            if(s.length() == 0) {//completely utilised given string
                res.add(curr.substring(0, curr.length()-1));//remove last added .
            }
        } else {
            for(int i = 1; i <= 3; i++) {//pick three NUMBERS(not digits) at a time
                if(s.length() < i)//if the amount of substring we're trying to chop is bigger than the current length of (remaining) string
                    break;
                String permutation = s.substring(0, i);
                int val = Integer.parseInt(permutation);
                //this value has to be <= 255 and not have leading zeroes for us to proceed with it
                if(val > 255 || i != String.valueOf(val).length())//i would be correct size and if permutation had leading zeroes, say 010, it's val will be 10, which when converted to string will have a length of 2
                    continue;
                //chop first i characters of s
                backtrack(index+1, curr+permutation+".", res, s.substring(i));
            }
        }
    }
}
