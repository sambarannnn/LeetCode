class Solution {
    
    public String intToRoman(int num) {
        HashMap<String, Integer> romans = new LinkedHashMap<String, Integer>();//using linkedhashmap to maintain insertion order
        romans.put("M", 1000);
        romans.put("CM", 900);//**
        romans.put("D", 500);
        romans.put("CD", 400);//**
        romans.put("C", 100);
        romans.put("XC", 90);//**
        romans.put("L", 50);
        romans.put("XL", 40);//**
        romans.put("X", 10);
        romans.put("IX", 9);//**
        romans.put("V", 5);
        romans.put("IV", 4);//**
        romans.put("I", 1);
        
        StringBuilder result = new StringBuilder();
        
        for(Map.Entry<String, Integer> entry : romans.entrySet()) {
            int symbol_freq = num / entry.getValue();
            if(symbol_freq == 0)//if this symbol's value is bigger than the current number, we skip this symnol
                continue;
            while(symbol_freq-- > 0) {
                result.append(entry.getKey());//repeatedly add this symbol
            }
            num = num % entry.getValue();//get rid of the most significant digit(leftmost)
        }
        return result.toString();
    }
}
