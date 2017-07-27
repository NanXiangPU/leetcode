public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (p == null || p.length() > s.length()) {
            return res;
        }
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        int count = 0;
        
        for (int i = 0; i < p.length(); ++i) {
            letter1[s.charAt(i) - 'a']++;
            letter2[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (letter1[i] == letter2[i]) {
                count++;
            }
        }
        for (int i = 0; i < s.length() - p.length(); ++i) {
            if (count == 26) {
                res.add(i);
            }
            int left = s.charAt(i) - 'a', right = s.charAt(i + p.length()) - 'a';
            
            letter1[left]--;
            if (letter1[left] == letter2[left]) {
                count++;
            } else if (letter1[left] == letter2[left] - 1){
                count--;
            }
            
            letter1[right]++;
            if (letter1[right] == letter2[right]) {
                count++;
            } else if(letter1[right] == letter2[right] + 1) {
                count--;
            }
        }
        if (count == 26) {
            res.add(s.length() - p.length());
        }
        return res;
    }
}