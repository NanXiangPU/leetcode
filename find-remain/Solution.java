public class Solution {
    private long remain = Integer.MAX_VALUE;
    public int findRemain(int divident, int divisor) {
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
        
        return sign * (int)remain;
    }
    
    public long helper(long divident, long divisor) {
        remain = Math.min(remain, divident);
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

    public static void main(String[] args) {
        Solution s = new Solution();
        int remain = s.findRemain(-7,2);
        System.out.println(remain);
    }
}