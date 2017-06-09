public class Solution {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        
        List<String> res = new ArrayList<>();
        Set<Character> firstRow = new HashSet<>();
        Set<Character> secondRow = new HashSet<>();
        Set<Character> thirdRow = new HashSet<>();
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";
        
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < first.length(); ++i) {
            firstRow.add(first.charAt(i));
        }
        list.add(firstRow);
        for (int i = 0; i < second.length(); ++i) {
            secondRow.add(second.charAt(i));
        }
        list.add(secondRow);
        for (int i = 0; i < third.length(); ++i) {
            thirdRow.add(third.charAt(i));
        }
        list.add(thirdRow);
        
        for (int i = 0; i < words.length; ++i) {
            String str = words[i];
            for (int j = 0; j < 3; ++j) {
                Set<Character> set = list.get(j);
                int count = 0;
                for (int p = 0; p < str.length(); ++p) {
                    if (set.contains(str.charAt(p))) {
                        count++;
                    }
                }
                if (count == str.length()) {
                    res.add(str);
                }
            }
        }
        String[] resArray = new String[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}