package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergedIntervals {
    public int[][] merge(int[][] intervals) {
        // if (intervals.length == 0) {
        //     return new int[0][0];
        // }
        //Sort the array in asc order 1st
        Arrays.sort(intervals, (el1, el2) -> Integer.compare(el1[0], el2[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        int[] prevInterval = intervals[0];
        mergedIntervals.add(prevInterval);
        for (int i = 1; i < intervals.length; i++) {
            //Overlapping so modify prevInterval
            if (intervals[i][0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(intervals[i][1], prevInterval[1]);
            }
            else {
                prevInterval = intervals[i];
                mergedIntervals.add(intervals[i]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}
