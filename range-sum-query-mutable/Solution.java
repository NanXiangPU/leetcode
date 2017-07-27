public class NumArray {
    int[] segTree;
    int len;
    public NumArray(int[] nums) {
        segTree = new int[nums.length * 2];
        len = nums.length;
        for (int i = len; i < segTree.length; ++i) {
            segTree[i] = nums[i - len];
        }
        for (int i = len - 1; i >= 0; --i) {
            segTree[i] = segTree[i * 2] + segTree[i * 2 + 1];
        }
    }
    
    public void update(int i, int val) {
        int index = i + len;
        segTree[index] = val;
        while (index > 0) {
            int left = index;
            int right = index;
            if (left % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            segTree[index / 2] = segTree[left] + segTree[right];
            index /= 2;
        }
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        int left = i + len, right = j + len;
        while (left <= right) {
            if (left % 2 != 0) {
                sum += segTree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += segTree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}