package linkedlist;

import java.util.Queue;
import java.util.LinkedList;

public class LC346MovingAverageFromDataStream {
    Queue<Integer> queue;
    int capacity;
    double currSum;

    public LC346MovingAverageFromDataStream(int size) {
        queue = new LinkedList<>();
        capacity = size;
        currSum = 0;
    }

    public double next(int val) {
        if (queue.size() == capacity) {
            currSum -= queue.poll();
        }
        queue.offer(val);
        currSum += (double) val;
        return ((double) (currSum / queue.size()));
    }
}
