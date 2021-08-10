class Solution {
    public boolean detectCapitalUse(String word) {
        int counter = 0;
        boolean flag = false;
        if(Character.isUpperCase(word.charAt(0)))
            flag = true;
        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c))
                counter++;
        }
        if((counter == 0) || (flag == true && counter == 1) || (counter == word.length()))
            return true;
        return false;
    }
}
