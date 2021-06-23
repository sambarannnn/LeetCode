class Solution {
    public boolean isUgly(int n) {
        //if a nos prime factors are limited to 2, 3, 5, after repeated divisions by each of these elements to max level possible, last remaining factor should just be 1
        int factor1 = 2;
        int factor2 = 3;
        int factor3 = 5;
        
        if(n == 0)
            return false;
        
        while(n % factor1 == 0)//while its divisible by 2
            n = n/factor1;//keep dividing
        
        while(n % factor2 == 0)//while its divisible by 3
            n = n/factor2;//keep dividing
        
        while(n % factor3 == 0)//while its divisible by 5
            n = n/factor3;//keep dividing
        
        //now, if it is an ugly number, original number should become 1
        if(n == 1)
            return true;
        else 
            return false;
    }
}
