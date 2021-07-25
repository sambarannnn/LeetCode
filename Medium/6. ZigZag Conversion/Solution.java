class Solution {
    public String convert(String s, int numRows) {
        //create numRows number of stringbuilders for building each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        char[] str = s.toCharArray();
        int length = str.length;
        
        int index = 0;
        while(index < length) {
            //fill vertically down
            for(int rowNo = 0; rowNo < numRows && index < length; rowNo++, index++) { //incrementing index too
                rows[rowNo].append(str[index]);
            }
            //fill obliquely (virtualy, it's just up for the middle section, as their surrounding elements will be empty only)
            //keep in mind, array is zero indexed
            for(int rowNo = (numRows-1) - 1; rowNo >= 1 && index < length; rowNo--, index++) { //incrementing index too
                rows[rowNo].append(str[index]);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) {//adding all thr wos to result, rowwise
            result.append(rows[i]);
        }
        return result.toString();
    }
}
