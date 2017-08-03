class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty() || prices.size() < 2) {
            return 0;
        }
        int minPrice = INT_MAX, res = INT_MIN;
        for (int i = 0; i < prices.size(); ++i) {
            minPrice = min(minPrice, prices[i]);
            res = max(res, prices[i] - minPrice);
        }
        return res;
    }
};