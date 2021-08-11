class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int i = 0;
        while(i < str.length) {
            if(str[i] != ' ') {
                int left = i;
                int right = i;
                while(right < str.length-1 && str[right+1] != ' ')
                    right++;
                reverse(str, left, right);
                i = right+1;
            } else {
                i++;
            }
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
