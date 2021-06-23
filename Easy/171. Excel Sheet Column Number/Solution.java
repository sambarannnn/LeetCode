class Solution {
    public int titleToNumber(String columnTitle) {
//For every additional digit of the string, we multiply the value of the digit by 26^n where n is the number of digits it is away from the one's place. This is similar to how the number 254 could be broken down as this: (2 x 10 x 10) + (5 x 10) + (4). The reason we use 26 instead of 10 is because 26 is our base.
//For s = "BCM" the final solution would be (2 x 26 x 26) + (3 x 26) + (13)


        char[] arr = columnTitle.toCharArray();
        int n = 0;
        int j = 0;
        //for ones place no need to multiply with base(26)
        //for tens place multiply w 26 once
        //for hundreds place thrice..so on
        for(int i = arr.length - 1; i >= 0; i--) {
            n += Math.pow(26, j)*(arr[i]-64);//-64 to get corresponding int
            j++;
        }
        return n;
    }
}
