package slidingwindow;

import java.util.*;

public class LC480SlidingWindowMedian {
    PriorityQueue<Integer> lo; // Store values in the left half of the sliding window. Top has the largest element in the left half
    PriorityQueue<Integer> hi; // Store values in the right half of the sliding window. Top has the smalled element in the right half
    Map<Integer, Integer> numsToBeDeletedMap;
    int loSize = 0;
    int hiSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
        numsToBeDeletedMap = new HashMap<>();
        double[] res = new double[nums.length - k + 1];

        //For nums till k, insert the nums in the heap
        for (int i = 0; i < k; i++) {
            insert(nums[i]);
        }
        //balance the heaps
        balance();
        //get the 1st median
        res[0] = getMedian(k);

        //Find the median for nums from k to nums.length
        for (int i = k; i < nums.length; i++) {
            insert(nums[i]);
            remove(nums[i - k]);
            balance();
            res[i - k + 1] = getMedian(k);
        }
        return res;
    }

    void insert (int num) {
        //If lo is empty then it will always get the num
        //Else if num <= top of lo then also it will get the num
        if (lo.isEmpty() || num <= lo.peek()) {
            lo.offer(num);
            loSize++;
        }
        else {
            hi.offer(num);
            hiSize++;
        }
    }

    void balance () {
        //If lo has more elements then remove from lo & add to hi
        while (loSize > hiSize + 1) {
            hi.offer(lo.poll());
            hiSize++;
            loSize--;
            prune(lo);
        }

        while (loSize < hiSize) {
            lo.offer(hi.poll());
            loSize++;
            hiSize--;
            prune(hi);
        }
    }

    /**
     * Keep removing elements from the q till top is not in nums to be deleted
     */
    void prune (PriorityQueue<Integer> q) {
        while (!q.isEmpty() && numsToBeDeletedMap.containsKey(q.peek())) {
            int num = q.peek();
            numsToBeDeletedMap.put(num, numsToBeDeletedMap.get(num) - 1);
            if (numsToBeDeletedMap.get(num) == 0)
                numsToBeDeletedMap.remove(num);
            q.poll();
        }
    }

    double getMedian (int k) {
        if (k % 2 == 0) {
            return (double) ((double) (lo.peek() + (double) hi.peek()) / 2);
        }
        return (double) lo.peek();
    }

    void remove (int num) {
        numsToBeDeletedMap.put(num, numsToBeDeletedMap.getOrDefault(num, 0) + 1);
        if (num <= lo.peek()) {
            loSize--;
            if (num == lo.peek()) {
                prune(lo);
            }
        }
        else {
            hiSize--;
            if (num == hi.peek()) {
                prune(hi);
            }
        }
    }

    //Commenting out the naive solution below::

//    public double[] medianSlidingWindow(int[] nums, int k) {
//        int start = 0, end = 0;
//        double[] res = new double[nums.length - k + 1];
//        int idx = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        while (end < nums.length) {
//            queue.offer(nums[end]);
//            end++;
//            if (queue.size() < k) {
//                continue;
//            }
//            res[idx] = getMedian(queue, k);
//            idx++;
//            queue.poll();
//            start++;
//        }
//        return res;
//    }
//
//    double getMedian (Queue<Integer> q, int k) {
//        List<Integer> sortedList = q.stream().sorted().collect(Collectors.toList());
//        // for (Integer num : sortedList)
//        //     System.out.print(num + " ");
//        // System.out.println();
//        // System.out.println(k/2);
//        if (k % 2 != 0)
//            return (double) sortedList.get(k / 2);
//        return (double) ((double) sortedList.get((k - 1) / 2) + (double) sortedList.get(k / 2)) / 2;
//    }
}
