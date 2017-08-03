public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num1.equals("0")) {
            return num2;
        }
        if (num2 == null || num2.length() == 0 || num2.equals("0")) {
            return num1;
        }
        int carry = 0;
        String res = "";
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int i = 0, j = 0;
            if (p1 >= 0) {
                i += Integer.parseInt(num1.charAt(p1--) + "");
            }
            if (p2 >= 0) {
                j += Integer.parseInt(num2.charAt(p2--) + "");
            }
            int sum = i + j + carry;
            res = sum % 10 + res;
            carry = sum / 10;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }
}