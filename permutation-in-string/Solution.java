public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1 == null || s1.length() == 0) {
            return false;
        }
        if (s2 == null || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }
        
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            letter1[s1.charAt(i) - 'a']++;
            letter2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (letter1[i] == letter2[i]) {
                count++;
            }
        }
        for (int i = 0; i < s2.length() - s1.length(); ++i) {
            if (count == 26) {
                return true;
            }
            int left = i, right = i + s1.length();
            

            letter2[s2.charAt(right) - 'a']++;
            if (letter2[s2.charAt(right) - 'a'] == letter1[s2.charAt(right) - 'a']) {
                count++;
            } else if (letter2[s2.charAt(right) - 'a'] == letter1[s2.charAt(right) - 'a'] + 1){
                count--;
            }
            
            letter2[s2.charAt(left) - 'a']--;           
            if (letter2[s2.charAt(left) - 'a'] == letter1[s2.charAt(left) - 'a']) {
                count++;
            } else if (letter2[s2.charAt(left) - 'a'] == letter1[s2.charAt(left) - 'a'] - 1){
                count--;
            }
            
            
            System.out.println(count);
        }
        
        return count == 26;
        
    }
}