public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                ++n;
                n = -n;
                x = 1/x;
                double res = x * myPow(x * x, n / 2);
                return res * x;
            }
            n = -n;
            x = 1/x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}