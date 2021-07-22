class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(i >= 0 && j >= 0) {
            int sum = Character.getNumericValue(num2.charAt(j)) + Character.getNumericValue(num1.charAt(i)) + carry;

            carry = sum / 10;

            res.append(sum % 10);
            i--;
            j--;
        }
        if(i < 0 && j >=0){
            while(j >= 0) {
                int sum = Character.getNumericValue(num2.charAt(j)) + carry;
                res.append(sum % 10);
                carry = sum / 10;
                j--;
            }
        } else if(i >= 0 && j < 0) {
            while(i >= 0) {
                int sum = Character.getNumericValue(num1.charAt(i)) + carry;
                res.append(sum % 10);
                carry = sum / 10;
                i--;
            }
        }
        if(carry != 0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
