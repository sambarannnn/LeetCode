class Solution {
     public String[] findWords(String[] words) {
         //array of 26 elements, corresponding to the 26 alphabets, we include their row number for each alphabet
         int[] line_map = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
         List<String> res = new ArrayList<>();
         for(String word : words) {
             char[] letters = word.toLowerCase().toCharArray();
             int line_number = line_map[letters[0] - 'a'];//line number of first letter in the word
             boolean valid = true;
             //now, all the other letters of this word need to have the same line number
             for(int i = 1; i < letters.length; i++) {
                 if(line_map[letters[i] - 'a'] != line_number) {//check line number of current letter
                     valid = false;
                     break;
                 }
             }
             if(valid) {
                 res.add(word);
             }
         }
         return res.toArray(new String[0]);
//         //creating three sets corresponding to each line of the keyboard
//         HashSet<Character> set1 = new HashSet<Character>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
//         HashSet<Character> set2 = new HashSet<Character>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
//         HashSet<Character> set3 = new HashSet<Character>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        
//         List<String> res = new ArrayList<>();
//         //for each word
//         for(String word : words) {
//             //take three flags for each line
//             boolean flag1 = true;
//             boolean flag2 = true;
//             boolean flag3 = true;
//             for(char c : word.toLowerCase().toCharArray()) {
//                 //for all the letters in this word, check them against all the sets
//                 //in any letter doesn't belong to a particular set, it will toggle that flag to false
//                 if(!set1.contains(c))
//                     flag1 = false;
//                 if(!set2.contains(c))
//                     flag2 = false;
//                 if(!set3.contains(c))
//                     flag3 = false;
//                 // System.out.println(flag1 +""+ flag2 +""+ flag3);
//             }
//             //if all flags are false, word does not belong on a single line
//             //if any one (or more, but not possible) of the flags is true, it belongs on a single line
//             if(flag1 || flag2 || flag3)//if it remains true for any of the sets
//                 res.add(word);
//             // System.out.println(flag1 +""+ flag2 +""+ flag3);
//         }
//         return res.toArray(new String[0]);
    }
}
