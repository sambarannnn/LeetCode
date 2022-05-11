class Solution {
    public int countVowelStrings(int n) {
        /*
        		  a  e  i  o  u
            n=1   1  1  1  1  1  /a, e, i, o, u
            n=2   5  4  3  2  1  /a-> aa,ae,ai,ao,au | e-> ee,ei,eo,eu | i-> ii,io,iu | o-> oo,ou | u-> uu
            n=3   15 10 6  3  1
        */
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for(int j = 1; j < n; j++) {
            o = o + u;
            i = i + o;
            e = e + i;
            a = a + e;
        }
        return a + e + i + o + u;
    }
}
// class Solution {
//     public int countVowelStrings(int n) {
//         int[] count = new int[]{0};
//         backtrack(0, count, n);
//         return count[0];
//     }
//     public void backtrack(int idx, int[] count, int n) {
//         if(n == 0){
//             count[0]++;
//             return;
//         }
//         for(int i = idx; i < 5; i++){
//             backtrack(i, count, n-1);
//         }
//     }
// }
// class Solution {
//     public int countVowelStrings(int n) {
//         char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
//         int[] count = new int[]{0};
//         backtrack(0, new StringBuilder(), vowels, count, n);
//         return count[0];
//     }
//     public void backtrack(int index, StringBuilder curr, char[] vowels, int[] count, int n) {
//         if(curr.length() == n) {
//             count[0]++;
//             return;
//         }
//         for(int i = index; i < vowels.length; i++) {
//             curr.append(vowels[i]);
//             backtrack(index, curr, vowels, count, n);
//             curr.deleteCharAt(curr.length()-1);
//         }
//     }
// }
