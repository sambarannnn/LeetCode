class Solution {
    /*
        OBSERVATIONS :
        1) If sum of digits becomes 1, it stays as 1 only
        2) If any sum value is repeated while calucalting sums, it shows the presence of a loop. for eg, after k steps, number n is found to repeat, it will keep repeating after every k steps.
        3)Approach 1 :
            Like linkedlist cycle detection algorithm.
            use 2 pointers, one fast and one slow
            slow one calculates sum (1 step)
            fast one calculates sum and then calculates sum of the first sum's digits(2 steps)
            at any point if fast becomes 1(see point 1), it stays at 1 while slow catches up to it
            if a sum value starts repeating, eventually there will be a situation wherein slow will be equal to fast. like in linkedlist cycle detection algo
            
        4) Approach 2 :
            use a hashset, it only stores unique values
            keep adding sum values to hashset
            if at any point, value cant be added(already present in hashset), loop detected, not a happy number
            if at any point sum becomes 1, then we have found the happy number
        */
    int sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
    //APPROACH 1
    boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sum(slow);
            if(slow == 1)//cutting off from loop if we get the 1 we need, no need for slow or fast to catch up to each other
                return true;
            fast = sum(fast);
            fast = sum(fast);
            if(fast == 1)//cutting off from loop if we get the 1 we need, no need for slow or fast to catch up to each other
                return true;
        } while(slow != fast);
        //if we dont put return statements inside the loop, we can wait for them to catch up and then check after loop termination
        //if(slow == 1)
            //return true;
            return false;
    }
    //APPROACH 2
    boolean HashSetisHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);//adding first number
        //in case n was 1 in the first place use do while loop
        do {
            int sumofdigits = sum(n);
            if(sumofdigits == 1)//1 is found
                return true;
            if(set.contains(sumofdigits))//cycle detected
                return false;
            set.add(sumofdigits);
            n = sumofdigits;
        } while(n != 1);
        return false;
    }
}
