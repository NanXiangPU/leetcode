public class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }
        int[] letter = new int[26];
        int[] valid = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            letter[s.charAt(i) - 'a']++;
        }
        for (int round = 0; round < s.length(); ++round) {
            int candidatePos = find(letter, valid, round);
            System.out.println(candidatePos);
            if (candidatePos == -1) {
                return "";
            }
            letter[candidatePos]--;
            valid[candidatePos] = round + k;
            sb.append((char)('a' + candidatePos)); 
        }
        return sb.toString();
    }
    
    public int find(int[] letter, int[] valid, int round) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for (int i = 0; i < letter.length; ++i) {
            if (letter[i] > 0 && letter[i] > max && round >= valid[i]) {
                max = letter[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
}