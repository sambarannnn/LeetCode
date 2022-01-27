class Solution {
    // public int[] relativeSortArray(int[] arr1, int[] arr2) {
    //     int[] cnt = new int[1001];
    //     for(int n : arr1) cnt[n]++;
    //     int i = 0;
    //     for(int n : arr2) {
    //         while(cnt[n]-- > 0) {
    //             arr1[i++] = n;
    //         }
    //     }
    //     for(int n = 0; n < cnt.length; n++) {
    //         while(cnt[n]-- > 0) {
    //             arr1[i++] = n;
    //         }
    //     }
    //     return arr1;
    // }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr2) {
            map.put(num, 0);
        }

        for(int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i])+1);
                arr1[i] = -1;
            } 
        }
        Arrays.sort(arr1);
        int index = 0;
        for(int num : arr2) {
            int freq = map.get(num);
            while(freq-- > 0) {
                arr1[index++] = num;
            }
        }
        return arr1;
    }
}
