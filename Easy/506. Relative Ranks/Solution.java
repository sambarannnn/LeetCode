class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < score.length; i++) {
            minheap.add(score[i]);
            map.put(score[i], i);//records position of each
        }
        //min score is at root
        String[] res = new String[score.length];
        while(!minheap.isEmpty()) {
            int pos = minheap.size();
            int index = map.get(minheap.remove());
            if(pos == 3) {
                res[index] = "Bronze Medal";
            } else if(pos == 2) {
                res[index] = "Silver Medal";
            } else if(pos == 1) {
                res[index] = "Gold Medal";
            } else {
                res[index] = String.valueOf(pos);
            }
        }
        return res;
    }
}
