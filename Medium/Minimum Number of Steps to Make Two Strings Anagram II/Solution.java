class Solution {
    public int minSteps(String s, String t) {
        int n = s.length(), m = t.length() , ans = 0;
        int[] arr = new int[26];
        for(int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < m; i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0)//unnecessary if condition, but just for understanding, excess of t will have negative and excess of s will have positive, and their equal pairs would have cancelled off
                ans += Math.abs(arr[i]);
        }
        return ans;
    }
}
