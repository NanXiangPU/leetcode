class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> sv(256), pv(256), res;
        if (s.empty() || p.empty() || s.size() < p.size()) {
            return res;
        }
        for (int i = 0; i < p.size(); ++i) {
            ++sv[s[i]];
            ++pv[p[i]];
        }
        if (sv == pv) {
            res.push_back(0);
        }
        for (int i = p.size(); i < s.size(); ++i) {
            ++sv[s[i]];
            --sv[s[i - p.size()]];
            if (sv == pv) {
                res.push_back(i - p.size() + 1);
            }
        }
        return res;
    }
};