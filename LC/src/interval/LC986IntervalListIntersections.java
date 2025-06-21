package interval;

import java.util.ArrayList;
import java.util.List;

public class LC986IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            //No intersection
            //If 1st interval starts after 2nd ends, increment j
            if (start1 > end2) {
                j++;
            }
            //No intersection
            //If 2nd interval starts after 1st ends, increment i
            else if (start2 > end1) {
                i++;
            }
            else {
                list.add(new int[]{Math.max(start1, start2), Math.min(end1, end2)});
                if (end1 > end2) {
                    j++;
                }
                else {
                    i++;
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
