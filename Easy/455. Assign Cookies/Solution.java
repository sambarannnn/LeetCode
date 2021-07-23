class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        
        int count = 0;
        
        while(i < g.length && j < s.length) {
            while(j < s.length && s[j] < g[i]){
                j++;
            }
            if(j < s.length && s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}
