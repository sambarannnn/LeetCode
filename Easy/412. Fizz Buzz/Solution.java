class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        //fizz and buzz counters refresh after printing each time
        //fizz prints when fizz counter is at 3
        //buzz prints when buzz counter is at 5
        //fizzbuzz when both are at 3, 5 respectively
        //can be customised for any given condition beyond this question
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        } 
        return ret;

        /*
        List<String> answer = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0)
                answer.add("FizzBuzz");
            else if(i % 5 == 0)
                answer.add("Buzz");
            else if(i % 3 == 0)
                answer.add("Fizz");
            else
                answer.add(String.valueOf(i));
        }
        return answer;
        */
    }
}
