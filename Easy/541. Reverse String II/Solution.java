class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i += 2*k) {
            int left = i;
            int right = Math.min(i + k - 1, str.length-1);
            reverse(str, left, right);
        }
        return new String(str);
    }
    private void reverse(char[] arr, int left, int right) {
        while(left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
