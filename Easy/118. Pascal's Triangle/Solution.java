class Solution {
    //dp
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        //adding first row
        triangle.add(new ArrayList<Integer>());
        //only element in first row is 1
        triangle.get(0).add(1);
        
        for(int currrow = 1; currrow < numRows; currrow++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevrow = triangle.get(currrow - 1);
            //first element is 1
            row.add(1);
            //filling middle elements. row(0) already has 1 row(currrow) will also be 1
            for(int j = 1; j < currrow; j++) {
                row.add(prevrow.get(j - 1) + prevrow.get(j));
            }
            
            //last element is 1
            row.add(1);
            //adding row to triangle
            triangle.add(row);
        }
        return triangle;
    }
}
