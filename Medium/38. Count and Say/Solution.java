class Solution {
    public String countAndSay(int n) {
        String answer = "1";//initialize with first element
        for(int i = 1; i < n; i++) {
            answer = function(answer);//for each iteration, calculate upon prev iteration's answer
        }
        return answer;
    }
    public String function(String curr) {
        //System.out.println(curr);
        StringBuilder res = new StringBuilder();
        int count = 1;
        int i = 0;
        for(; i < curr.length ()- 1; i++) {
            if(curr.charAt(i) == curr.charAt(i+1)){//if this ele is equal to next
                count++;//increase count
                //in case last eles were equal loop terminates here, taken care of after the loop
            } else {
                res.append(count);//append count
                res.append(curr.charAt(i));//append character
                count = 1;//reset count to check next element
                //even if loop exits here cuz last ele is not equal to 2nd last, i will be pointing at last ele and count has been reset to 1; taken care of outside loop
            }
        }
        res.append(count);
        res.append(curr.charAt(i));
        return res.toString();
    }
}
