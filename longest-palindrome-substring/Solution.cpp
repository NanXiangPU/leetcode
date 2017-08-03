class Solution {
private:
    int lo, maxLen;
    void expand(string s, int i, int j) {
        while(i >= 0 && j < s.size() && s[i] == s[j]) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            maxLen = j - i - 1;
            lo = i + 1;
        }
    }
public:
    string longestPalindrome(string s) {
        if (s.empty() || s.size() == 1) {
            return s;
        }
        for (int i = 0; i < s.size() - 1; ++i) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substr(lo, maxLen);
    }
};