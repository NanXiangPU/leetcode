public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || a.equals("0")) {
            return b;
        }
        if (b == null || b.length() == 0 || b.equals("0")) {
            return a;
        }
        int carry = 0;
        String res = "";
        int p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int i = 0, j = 0;
            if (p1 >= 0) {
                i += Integer.parseInt(a.charAt(p1--) + "");
            }
            if (p2 >= 0) {
                j += Integer.parseInt(b.charAt(p2--) + "");
            }
            res = (i + j + carry) % 2 + res;
            carry = (i + j + carry) / 2;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }

    public String addOtc(String a, String b) {
        if (a == null || a.length() == 0 || a.equals("0")) {
            return b;
        }
        if (b == null || b.length() == 0 || b.equals("0")) {
            return a;
        }
        int carry = 0;
        String res = "";
        int p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int i = 0, j = 0;
            if (p1 >= 0) {
                i += Integer.parseInt(a.charAt(p1--) + "");
            }
            if (p2 >= 0) {
                j += Integer.parseInt(b.charAt(p2--) + "");
            }
            res = (i + j + carry) % 8 + res;
            carry = (i + j + carry) / 8;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }

    public String addDecimal(String a, String b) {
        if (a == null || a.length() == 0 || a.equals("0")) {
            return b;
        }
        if (b == null || b.length() == 0 || b.equals("0")) {
            return a;
        }
        int carry = 0;
        String res = "";
        int p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int i = 0, j = 0;
            if (p1 >= 0) {
                i += Integer.parseInt(a.charAt(p1--) + "");
            }
            if (p2 >= 0) {
                j += Integer.parseInt(b.charAt(p2--) + "");
            }
            res = (i + j + carry) % 10 + res;
            carry = (i + j + carry) / 10;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }

    public String addHex(String a, String b) {
        if (a == null || a.length() == 0 || a.equals("0")) {
            return b;
        }
        if (b == null || b.length() == 0 || b.equals("0")) {
            return a;
        }
        int carry = 0;
        String res = "";
        int p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int i = 0, j = 0;
            if (p1 >= 0) {
                if (Character.isDigit(a.charAt(p1))) {
                    i += Integer.parseInt(a.charAt(p1--) + "");
                } else {
                    switch(a.charAt(p1)) {
                        case 'a' :
                            i += 10;
                            break;
                        case 'b' :
                            i += 11;
                            break;
                        case 'c':
                            i += 12;
                            break;
                        case 'd':
                            i += 13;
                            break;
                        case 'e':
                            i += 14;
                            break;
                        case 'f':
                            i += 15;
                            break;
                        default:
                            i += Integer.parseInt(a.charAt(p1) + "");
                            break;
                        }
                    p1--;
                }
                
            }
            if (p2 >= 0) {
                if (Character.isDigit(a.charAt(p2))) {
                    j += Integer.parseInt(b.charAt(p2--) + "");
                } else {
                    switch(b.charAt(p2)) {
                        case 'a' :
                            j += 10;
                            break;
                        case 'b' :
                            j += 11;
                            break;
                        case 'c':
                            j += 12;
                            break;
                        case 'd':
                            j += 13;
                            break;
                        case 'e':
                            j += 14;
                            break;
                        case 'f':
                            j += 15;
                            break;
                        default:
                            j += Integer.parseInt(b.charAt(p2) + "");
                            break;
                        }
                    p2--;
                }
                
            }
            String toAdd = "";
            switch((i + j + carry) % 16) {
                        case 10:
                            toAdd = "a";
                            break;
                        case 11 :
                            toAdd = "b";
                            break;
                        case 12 :
                            toAdd = "c";
                            break;
                        case 13 :
                            toAdd = "d";
                            break;
                        case 14 :
                            toAdd = "e";
                            break;
                        case 15:
                            toAdd = "f";
                            break;
                        default:
                            toAdd = "" + (i + j + carry) % 16;
                            break;
                        }
            res = toAdd + res;
            carry = (i + j + carry) / 16;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "a3";
        String b = "c";
        System.out.println(s.addHex(a, b));
    }
}