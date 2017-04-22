public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            int a = (int)(n / m);
            int b = (int)(n % m);
            ones += (a + 8) / 10 * m + ((a % 10 == 1) ? b + 1 : 0);
        }
        return ones;
    }
}