public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int ri = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[ri++] = nums[queue.peek()];
            }
        }
        return res;
    }
}