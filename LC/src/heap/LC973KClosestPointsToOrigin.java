package heap;

import java.util.PriorityQueue;

public class LC973KClosestPointsToOrigin {

    class Point {
        int[] point;
        int dist;

        Point (int[] point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }

    public int[][] kClosest (int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((el1, el2) -> Integer.compare(el2.dist, el1.dist));

        for (int idx = 0; idx < points.length; idx++) {
            int dist = (points[idx][0] * points[idx][0]) + (points[idx][1] * points[idx][1]);
            Point point = new Point(points[idx], dist);
            if (maxHeap.size() < k) {
                maxHeap.offer(point);
            }
            else {
                if (maxHeap.peek().dist > dist) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }

        int counter = 0;
        while (!maxHeap.isEmpty()) {
            Point pt = maxHeap.poll();
            res[counter][0] = pt.point[0];
            res[counter][1] = pt.point[1];
            counter++;
        }
        return res;
    }

//    public int[][] kClosest (int[][] points, int k) {
//        int[][] res = new int[k][2];
//        PriorityQueue<Point> heap = new PriorityQueue<>((el1, el2) -> Integer.compare(el1.dist, el2.dist));
//
//        for (int idx = 0; idx < points.length; idx++) {
//            int dist = (int) Math.sqrt(Math.pow(points[idx][0], 2) + Math.pow(points[idx][1], 2));
//            Point point = new Point(points[idx], dist);
//            heap.offer(point);
//        }
//
//        int counter = 0;
//        while (counter < k) {
//            Point pt = heap.poll();
//            res[counter][0] = pt.point[0];
//            res[counter][1] = pt.point[1];
//            counter++;
//        }
//        return res;
//    }

    public static void main (String[] args) {
        LC973KClosestPointsToOrigin lc973KClosestPointsToOrigin = new LC973KClosestPointsToOrigin();
//        System.out.println(lc973KClosestPointsToOrigin.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2));
        System.out.println(lc973KClosestPointsToOrigin.kClosest(new int[][]{{2,10},{-9,-9},{0,8},{-2,-2},{8,9},{-10,-7},{-5,2},{-4,-9}}, 7));
    }
}
