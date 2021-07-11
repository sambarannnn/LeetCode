class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> prevRow = result.get(result.size() - 1);
            List<Integer> currRow = new ArrayList<Integer>();
            currRow.add(1);//first element is 1
            
            for(int index = 0; index < prevRow.size() - 1; index++) {
                int ele = prevRow.get(index) + prevRow.get(index+1);
                currRow.add(ele);
            }
            
            currRow.add(1);//last element is 1
            result.add(currRow);
        }
        return result.get(result.size() - 1);
    }
}
