class Solution {
    public int largestRectangleArea(int[] heights) {
        List<Integer> h = new ArrayList<Integer>(heights.length);
        for (int i : heights)
            h.add(i);

        int n = h.size();
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        //loop to fill in left limits
        for(int i = 0; i < n; i++) {
            if(st.empty()) {
                left[i] = 0;//set ith location to 0 since thats the left limit
                st.push(i);//push index into stack
            } else {
                while(!st.empty() && h.get(st.peek()) >= h.get(i)) {//until you find a smaller or equal height bar, keep popping
                    st.pop();
                }
                if(st.empty())
                    left[i] = 0;
                else
                    left[i] = st.peek()+1;
                st.push(i);
            }
        }
        //left contains all the left limits per index
        //reuse same stack for tracking right limits
        st.clear();
        //loop to fill in right limits, runs from last index to first
        for(int i = n-1; i >= 0; i--) {
            if(st.empty()) {
                right[i] = n-1;//set ith location to n-1(last index) since thats the right limit for last bar
                st.push(i);//push index into stack
            } else {
                while(!st.empty() && h.get(st.peek()) >= h.get(i)) {
                    st.pop();
                }
                if(st.empty())
                    right[i] = n-1;
                else
                    right[i] = st.peek()-1;
                st.push(i);
            }
        }
        int max_area = 0;
        //for each bar calculate area using left limit and right limit
        for(int i = 0; i < n; i++) {
            max_area = Math.max(max_area, h.get(i) * (right[i] -left[i] + 1));
        }
        return max_area;
    }
}
