public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> list = grayCode(n - 1);
        int last = list.get(list.size() - 1);
        int add = 2;
        while (last / 2 != 0) {
            last = last / 2;
            add *= 2;
        }
        for (int i = list.size() - 1; i >= 0; --i) {
            int val = list.get(i);
            list.add(val + add);
        }
        return list;
    }
}