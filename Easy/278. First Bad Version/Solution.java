/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //binary search
        int first = 1;
        int last = n;
        
        while(first < last) {
            
            int mid = first + ((last-first)/2);
            
            if(isBadVersion(mid))//if mid version is bad, first bad version can be at it's left
                last = mid;
            else//if mid version is good, bad version HAS to be towards right
                first = mid+1;
        }
        //when loop exits, both first and last are pointing at first bad version, return any
        return first;
        
    }
}
