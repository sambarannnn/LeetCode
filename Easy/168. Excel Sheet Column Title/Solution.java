class Solution {
    public String convertToTitle(int columnNumber) {
        int radix = 'Z' - 'A' + 1;//26
        StringBuilder res = new StringBuilder();
        //WE NEED TO MAP 1 TO 0
        //SINCE A STARTS FROM 0
        
        while(columnNumber > 0) {
            columnNumber = columnNumber - 1;
            char curr = (char)(columnNumber%radix + 'A');
            res.append(curr);
            
            columnNumber = columnNumber/radix;
        }
        
        return res.reverse().toString();
    }
}
