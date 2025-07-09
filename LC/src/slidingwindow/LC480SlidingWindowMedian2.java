package slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC480SlidingWindowMedian2 {
    PriorityQueue<Integer> leftHeap = new PriorityQueue<>((el1, el2) -> Integer.compare(el2, el1));
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    Map<Integer, Integer> numsToBeDeletedMap;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0, idx = 0;
        double res[] = new double[nums.length - k + 1];
        numsToBeDeletedMap = new HashMap<>();
        while (right < nums.length) {
            if (leftHeap.isEmpty() && rightHeap.isEmpty()) {
                leftHeap.offer(nums[right]);
            }
            else if (nums[right] > leftHeap.peek()) {
                rightHeap.offer(nums[right]);
            }
            else {
                leftHeap.offer(nums[right]);
            }
            System.out.println("num => " + nums[right] + " :: Left => " + leftHeap.peek() + " :: Right => " + rightHeap.peek());
            balanceHeap();
            if (right - left == k - 1) {
                res[idx++] = getMedian(k);
                numsToBeDeletedMap.put(nums[left], numsToBeDeletedMap.getOrDefault(nums[left], 0) + 1);
                cleanupHeap();
                left++;
            }
            right++;
        }
        return res;
    }

    double getMedian (int k) {
        if (k % 2 == 0) {
            return (double) ((double) (leftHeap.peek() + (double) rightHeap.peek()) / 2);
        }
        return leftHeap.peek();
    }

    void cleanupHeap () {
        while (!leftHeap.isEmpty() && numsToBeDeletedMap.containsKey(leftHeap.peek())) {
            int n = leftHeap.poll();
            numsToBeDeletedMap.put(n, numsToBeDeletedMap.get(n) - 1);
            if (numsToBeDeletedMap.get(n) == 0) {
                numsToBeDeletedMap.remove(n);
            }
        }
        while (!rightHeap.isEmpty() && numsToBeDeletedMap.containsKey(rightHeap.peek())) {
            int n = rightHeap.poll();
            numsToBeDeletedMap.put(n, numsToBeDeletedMap.get(n) - 1);
            if (numsToBeDeletedMap.get(n) == 0) {
                numsToBeDeletedMap.remove(n);
            }
        }
        balanceHeap();
    }

    void balanceHeap () {
        while (leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.offer(leftHeap.poll());
        }
        while (rightHeap.size() > leftHeap.size()) {
            leftHeap.offer(rightHeap.poll());
        }
    }

    public static void main (String[] args) {
        LC480SlidingWindowMedian2 lc = new LC480SlidingWindowMedian2();
        System.out.println(lc.medianSlidingWindow(new int [] {1,3,-1,-3,5,3,6,7}, 3));
    }
}
