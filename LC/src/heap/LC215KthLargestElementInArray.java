package heap;

import java.util.PriorityQueue;

public class LC215KthLargestElementInArray {

    public int findKthLargest (int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((el1, el2) -> Integer.compare(el2, el1));
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }
        int el = 0;
        for (int idx = 0; idx < k; idx++) {
            el = maxHeap.poll();
        }
        return el;
    }


    public static void main (String[] args) {
        LC215KthLargestElementInArray lc215KthLargestElementInArray = new LC215KthLargestElementInArray();
        System.out.println(lc215KthLargestElementInArray.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(lc215KthLargestElementInArray.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

}
