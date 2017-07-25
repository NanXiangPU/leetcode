public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[count++] = nums[queue.peek()];
            }
        }
        return res;
    }
}