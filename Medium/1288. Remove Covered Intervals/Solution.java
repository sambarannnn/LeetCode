class intervalsComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] entry1, int[] entry2) {
 
        if (entry1[0] > entry2[0]) {
            return 1;
        } else if(entry1[0] < entry2[0]) {
            return -1;
        } else if(entry1[1] > entry2[1]) {
            return -1;
        } else if(entry1[1] < entry2[1]) {
            return 1;
        } else {
            return -1;
        }
    }
}
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, new intervalsComparator());
        int maxEnd = intervals[0][1];
        int res = intervals.length;
        for(int i = 1; i < intervals.length; i++) {
            // System.out.println(intervals[i][1] + " | " + maxEnd);
            if(intervals[i][1] <= maxEnd) {
                res--;
            }
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }
        
        return res;
    }
}
