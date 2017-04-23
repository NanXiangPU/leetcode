public class Solution{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        for (int i = 0; i < numRows; ++i) {
            if (i == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                res.add(list);
            }
            else {
                List<Integer> pre = res.get(res.size() - 1);
                List<Integer> list = new ArrayList<>();
                list.add(pre.get(0));
                for (int j = 1; j < pre.size(); ++j) {
                    int tmp = pre.get(j - 1) + pre.get(j);
                    list.add(tmp);
                }
                list.add(pre.get(pre.size() - 1));
                res.add(list);
            }
        }
        return res;
    }
}