class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        int len = flowerbed.length;
        int i = 0;
        
        while(i < len) {
            if(i != 0 && flowerbed[i-1] == 1)
                i += 1;
            else if(flowerbed[i] == 1)
                i += 2;
            else if(i+1 < len && flowerbed[i+1] == 1)
                i += 3;
            else {
                n--;
                flowerbed[i] = 1;
                if(n == 0)
                    return true;
            }
        }
        return false;
    }
}
