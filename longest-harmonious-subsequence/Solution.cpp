class Solution {
public:
    int findLHS(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }
        int res = 0;
        map<int, int> map;
        for (int n : nums) {
            map[n]++;
        }
        for (auto it : map) {
            if (map.find(it.first + 1) != map.end()) {
                res = max(res, map[it.first] + map[it.first + 1]);
            }
        }
        return res;
    }
};