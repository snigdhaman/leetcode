package slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class LC239SlidingWindowMax {

    public int[] maxSlidingWindow (int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0, right = 0;

        while (right < nums.length) {
            while (!deque.isEmpty() && (deque.peekLast() < nums[right])) {
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            if (right - left == k - 1) {
                res[left] = deque.peekFirst();
                if (nums[left] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main (String[] args) {
        LC239SlidingWindowMax lc239SlidingWindowMax = new LC239SlidingWindowMax();
        System.out.println(lc239SlidingWindowMax.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
        System.out.println(lc239SlidingWindowMax.maxSlidingWindow(new int[] {1}, 1));
    }
}
