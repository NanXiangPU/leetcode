public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> resSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        int[] res = new int[resSet.size()];
        int count = 0;
        for (Integer i : resSet) {
            res[count++] = i;
        }
        return res;
    }
}