public class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for(int i = 0; i < 32; ++i) {
            int x_bit = (x >> i) & 1;
            int y_bit = (y >> i) & 1;
            if (x_bit != y_bit) {
                res += 1;
            }
        }
        return res;
    }
}
