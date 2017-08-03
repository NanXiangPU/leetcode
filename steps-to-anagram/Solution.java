public class Solution {
	public int stepsToAnagram(String a, String b) {
		if ((a == null && b != null) || (a != null && b == null)) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		if (a.length() != b.length()) {
			return -1;
		}
		int[] ASCII = new int[128];
		int res = 0;
		for (int i = 0; i < a.length(); ++i) {
			ASCII[a.charAt(i)]++;
			ASCII[b.charAt(i)]--;
		}
		for (int i = 0; i < 128; ++i) {
			if (ASCII[i] > 0) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String a = "abcde";
		String b = "aaaaa";
		System.out.println(s.stepsToAnagram(a, b));
	}
}
/*
static int[] getMinimumDifference(String[] a, String[] b) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            String s1 = a[i];
            String s2 = b[i];
            if (s1.length() != s2.length()) {
                res[i] = -1;
                continue;
            }
            int[] letter = new int[26];
            int count = 0;
            for (int j = 0; j < s1.length(); ++j) {
                letter[s1.charAt(j) - 'a']++;
                letter[s2.charAt(j) - 'a']--;
            }
            for (int j = 0; j < 26; ++j) {
                if (letter[j] > 0) {
                    count += letter[j];
                }
            }
            res[i] = count;
        }
        return res;
    }
*/