class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            if(rotatedMatch(s, goal, i))
                return true;
        }
        return false;
    }
    private boolean rotatedMatch(String s, String goal, int rotation) {
        for(int i = 0; i < goal.length(); i++) {
            if(goal.charAt(i) != s.charAt((i + rotation) % s.length()))
                return false;
        }
        return true;
    }
}
