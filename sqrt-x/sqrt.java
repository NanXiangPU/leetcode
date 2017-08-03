public class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }else if(x < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int left = 1, right = x;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(mid == x / mid || (mid < x / mid && (mid + 1) > x / (mid + 1))) {
                return mid;
            }else if(mid < x / mid) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if(left == x / left || (left < x / left && (left + 1) > x / (left + 1))) {
            return left;
        }else{
            return right;
        }
    }
}