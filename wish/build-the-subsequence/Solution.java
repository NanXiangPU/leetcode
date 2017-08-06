/*
 * Complete the function below.
 */

    static String[] buildSubsequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        helper(res, new StringBuilder(), s, 0);
        String[] resArr = new String[res.size()];
        for (int i = 0; i < resArr.length; ++i) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private static void helper(List<String> res, StringBuilder sb, String s, int start) {
        if (sb.length() != 0) {
            res.add(new StringBuilder(sb).toString());
        }
        for (int i = start; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            helper(res, sb, s, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

