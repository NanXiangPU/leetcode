class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; --i) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}