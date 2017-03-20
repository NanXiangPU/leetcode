public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return null;
        }
        if(b == null || b.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int pt1 = a.length() - 1, pt2 = b.length() - 1, carry = 0;
        while(pt1 >= 0 || pt2 >= 0) {
            int sum = carry;
            if(pt1 >= 0) {
                sum += a.charAt(pt1--) - '0';
            }
            if(pt2 >= 0) {
                sum += b.charAt(pt2--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}