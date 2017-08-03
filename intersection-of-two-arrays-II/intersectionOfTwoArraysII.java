public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); ++i) {
            resArray[i] = (int)res.get(i);
        }
        return resArray;
    }
}