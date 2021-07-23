class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        s = s.replace("-", "");
        StringBuilder res = new StringBuilder();
        res.append(s);
        res.reverse();
        for(int i = 0; i < res.length(); i = i + k +1) {
            if(i+k < res.length())
                res.insert((i+k), "-");
        }
        return res.reverse().toString();
    }
}
