class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int number = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i != s.length() - 1){
                if(s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                    number+= roman.get(s.charAt(i+1)) - 1;
                    i++;
                } else if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    number+= roman.get(s.charAt(i+1)) - 10;
                    i++;
                } else if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    number+= roman.get(s.charAt(i+1)) - 100;
                    i++;
                } else
                    number+= roman.get(s.charAt(i));
            } else 
                number+= roman.get(s.charAt(i));
        }
        return number;
    }
}
