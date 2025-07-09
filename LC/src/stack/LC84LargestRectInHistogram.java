package stack;

import java.util.Stack;

public class LC84LargestRectInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int area = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                area = Math.max(area, heights[i]);
            }
            else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int poppedIdx = stack.pop();
                    int ht = (i - poppedIdx) * heights[poppedIdx];
                    area = Math.max(area, ht);
                }
                if (!stack.isEmpty() && heights[stack.peek()] != heights[i]) {
                    stack.push(i);
                }
                area = Math.max(area, heights[i]);
            }
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            area = Math.max(area, (n) * heights[idx]);

        }

        return area;
    }

    public static void main (String[] args) {
        LC84LargestRectInHistogram lc = new LC84LargestRectInHistogram();
//        System.out.println(lc.largestRectangleArea(new int[] {2,1,5,6,2,3}));
        System.out.println(lc.largestRectangleArea(new int[] {1,1}));
    }
}
