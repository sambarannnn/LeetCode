class Solution {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[2];
        for(char move : moves.toCharArray()) {
            switch(move) {
                case 'R' :
                    pos[0]++;
                    break;
                case 'L' :
                    pos[0]--;
                    break;
                case 'U' :
                    pos[1]++;
                    break;
                case 'D' :
                    pos[1]--;
                    break;
            }
        }
        if(pos[0] == 0 && pos[1] == 0)
            return true;
        else
            return false;
    }
}
