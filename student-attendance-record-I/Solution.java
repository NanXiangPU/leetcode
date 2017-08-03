public class Solution {
    //Solution 1
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int countOfA = 0;
        int countOfL = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'A') {
                countOfA++;
            }
            if (s.charAt(i) == 'L') {
                int pt = i + 1;
                int count = 1;
                while (pt < s.length() && s.charAt(pt) == 'L') {
                    count++;
                    pt++;
                }
                if (count > 2) {
                    return false;
                }
            }
        }
        if (countOfA <= 1) {
            return true;
        }
        return false;
    }

    //Solution 2
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }

    //Solution 3
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}