class Solution {
    public boolean checkRecord(String s) {
        int absentDays = 0;
        int lateConsec = 0;
        for(char c : s.toCharArray()) {
            if(c == 'A')
                absentDays++;
            if(c == 'L')
                lateConsec++;
            else
                lateConsec = 0;
            if(absentDays >= 2 || lateConsec >= 3)
                return false;
        }
        return true;
    }
}
