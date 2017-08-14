public class Solution {
    String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int count = 0;
        String res = "";
        while (num != 0) {
            int sub = num % 1000;
            if (sub != 0) {
                res = helper(sub) + THOUSANDS[count] + " " + res;
            }
            count++;
            num /= 1000;
        }
        return res.trim();
    }
    
    public String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return ONES[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return ONES[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}