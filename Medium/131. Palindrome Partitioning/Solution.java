class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();    
        List<String> partitions = new ArrayList<String>();
        DFSchecker(s, partitions, result);
        return result;
    }
    
    private void DFSchecker(String s, List<String> partitions, List<List<String>> result) {
        
        if(s.length() == 0) {//if we're checking empty string, then at this point, this partitions list is complete, add it to final result
            result.add(new ArrayList<String>(partitions));
            return;
            //while returning, we remove each added partition(backtrack) to fish for bigger palindromic partitions to append
        }
        
        for(int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i+1);
            
            if(isPalindrome(prefix)) {
                partitions.add(prefix);//add this palindromic partition
                String tobechecked = s.substring(i+1);//check the rest of the string
                DFSchecker(tobechecked, partitions, result);
                //while returning, we remove each added partition(backtrack) to fish for bigger palindromic partitions to append
                partitions.remove(partitions.size() - 1);//decrementing partition (going back)
            }
        }
    }
    
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
}
