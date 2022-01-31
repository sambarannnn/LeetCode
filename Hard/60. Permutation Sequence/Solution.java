class Solution {
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<String>();
        backtrack(n, new boolean[n+1], new StringBuilder(), res, k);
        // Collections.sort(res);
        // for(String str : res) {
        //     System.out.println(str);
        // }
        return res.get(k-1);
    }
    
    public void backtrack(int n, boolean[] visited, StringBuilder curr, List<String> res, int k) {
        if(curr.length() == n){
            res.add(curr.toString());
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(res.size() == k)
                return;
            if(visited[i] == false) {
                visited[i] = true;;
                curr.append(i);
                backtrack(n, visited, curr, res, k);
                curr.deleteCharAt(curr.length()-1);
                visited[i] = false;
            }   
        }
    }
}
