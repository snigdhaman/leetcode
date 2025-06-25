package heap;

import java.util.PriorityQueue;

public class LC378KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((el1, el2) -> Integer.compare(el2, el1));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(matrix[i][j]);
                }
                else if (maxHeap.peek() > matrix[i][j]) {
                    maxHeap.poll();
                    maxHeap.offer(matrix[i][j]);
                }
            }
        }
        return maxHeap.poll();
    }
}
