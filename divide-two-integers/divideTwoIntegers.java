public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        long res = 0;
        int sign = ((dividend < 0) == (divisor < 0)) ? 1 : -1;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        while(a >= b) {
            long tmp = b, i = 1;
            while(a >= tmp) {
                a -= tmp;
                res += i;
                if((sign == 1 && res > Integer.MAX_VALUE) || (sign == -1 && -res < Integer.MIN_VALUE)) {
                    return Integer.MAX_VALUE;
                }
                tmp <<= 1;
                i <<= 1;    
            }
        }
        return (int)res * sign;
    }
}