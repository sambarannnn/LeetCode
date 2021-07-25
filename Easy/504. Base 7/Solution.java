class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        boolean isNeg = false;
        if(num < 0) {
            isNeg = true;
            num = -1 * num;
        }
        StringBuilder res = new StringBuilder();
        while(num > 0) {
            res.append(num % 7);
            num = num / 7;
        }
        if(isNeg)
            res.append("-");
        
        return res.reverse().toString();
    }
}
