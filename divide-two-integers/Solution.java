public class Solution {
    public int divide(int divident, int divisor) {
        int ans = 0;
        if (divident == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((divident < 0 && divisor > 0) || (divident > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldivident = Math.abs((long)divident);
        long ldivisor = Math.abs((long)divisor); 
        
        long res = helper(ldivident, ldivisor);
        
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int)res * sign;
        }
        return ans;
    }
    
    public long helper(long divident, long divisor) {
        if (divident < divisor) {
            return 0;
        }
        long sum = divisor, count = 1;
        while (divident >= sum + sum) {
            sum += sum;
            count += count;
        }
        return count + helper(divident - sum, divisor);
    }
}