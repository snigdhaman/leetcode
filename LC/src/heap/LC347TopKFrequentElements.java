package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347TopKFrequentElements {

    public int[] topKFrequent (int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int num : nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (el1, el2) -> Integer.compare(el1.getValue(), el2.getValue()));

        for (Map.Entry<Integer, Integer> mapEntry: numFrequencyMap.entrySet()) {
            maxHeap.offer(mapEntry);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }


    public static void main (String[] args) {
        LC347TopKFrequentElements lc347TopKFrequentElements = new LC347TopKFrequentElements();
//        Utils.printList(Arrays.asList(lc347TopKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
//        Utils.printList(Arrays.asList(lc347TopKFrequentElements.topKFrequent(new int[]{1}, 1)));
    }
}
