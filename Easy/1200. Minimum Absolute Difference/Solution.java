class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] > minDiff) {
                continue;
            }
            if(arr[i] - arr[i-1] < minDiff) {
                minDiff = arr[i] - arr[i-1];
                res.clear();
            }
            //for <=
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(arr[i-1]); curr.add(arr[i]);
            res.add(curr);
        }
        return res;
    }
}
