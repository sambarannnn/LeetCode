class Solution {
    public String multiply(String num1, String num2) {
        //for 2 numbers of length n1 and n2
        //their product will have the max length of n1+n2
        int[] product = new int[num1.length() + num2.length()];
        
        //in first pass, append all products, dont worry about carry overs
        for(int i = num2.length()-1; i >= 0; i--) {
            for(int j = num1.length()-1; j >= 0; j--) {
                int d1 = (num2.charAt(i)-'0');
                int d2 = (num1.charAt(j) - '0');
                product[i+j+1] += d1 * d2;
            }
        }
        //now, manage the carries
        int carry = 0;
        for(int i = product.length-1; i >= 0; i--) {
            product[i] = product[i] + carry;
            carry = product[i]/10;
            product[i] = product[i] % 10;//removing msb(left)
        }
        
        StringBuilder result = new StringBuilder();
        //ignoring leading zeroes
        int index = 0;
        for(; index < product.length; index++) {
            if(product[index] != 0)
                break;
        }
        //if all of the digits were zero
        if(index == product.length)
            return "0";
        for(; index < product.length; index++) {
            result.append(product[index]);
        }
        return result.toString();
    }
}
