package arraysandhashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1762BuildingsWithOceanView {

//    public int[] findBuildings (int[] heights) {
//        Stack<Integer> buildingIndexStack = new Stack<>();
//        Stack<Integer> buildingStack = new Stack<>();
//
//        for (int i = 0; i < heights.length; i++) {
//            while (!buildingStack.isEmpty() && heights[i] > buildingStack.peek()) {
//                buildingStack.pop();
//                buildingIndexStack.pop();
//            }
//            buildingStack.push(heights[i]);
//            buildingIndexStack.push(i);
//        }
//        int[] res = new int[buildingIndexStack.size()];
//        int idx = 0;
//        for (Integer buildingIndex : buildingIndexStack) {
//            res[idx] = buildingIndex;
//            idx++;
//        }
//        return res;
//    }

    public int[] findBuildings (int[] heights) {
        int maxHeight = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                res.add(i);
            }
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main (String[] args) {
        LC1762BuildingsWithOceanView lc1762BuildingsWithOceanView = new LC1762BuildingsWithOceanView();
        System.out.println(lc1762BuildingsWithOceanView.findBuildings(new int[]{4,2,3,1}));
        System.out.println(lc1762BuildingsWithOceanView.findBuildings(new int[]{4,3,2,1}));
        System.out.println(lc1762BuildingsWithOceanView.findBuildings(new int[]{1,3,2,4}));
    }

}
