package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1094CarPooling {
    class Trip {
        int passengers;
        int endTime;

        public Trip (int passengers, int endTime) {
            this.passengers = passengers;
            this.endTime = endTime;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (el1, el2) -> Integer.compare(el1[1], el2[1]));
        PriorityQueue<Trip> minHeap = new PriorityQueue<>((el1, el2) -> Integer.compare(el1.endTime, el2.endTime));

        int currCapacity = 0;

        for (int[] trip : trips) {
            int pass = trip[0];
            int start = trip[1];
            int end = trip[2];

            while (minHeap.size() > 0 && minHeap.peek().endTime <= start) {
                currCapacity -= minHeap.peek().passengers;
                minHeap.poll();
            }

            currCapacity += pass;
            if (currCapacity > capacity) {
                return false;
            }

            minHeap.offer(new Trip(pass, end));
        }

        return true;
    }
}
