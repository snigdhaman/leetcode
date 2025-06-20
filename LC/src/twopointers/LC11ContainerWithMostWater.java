package twopointers;

public class LC11ContainerWithMostWater {

    public int maxArea (int[] height) {
        int maxArea = 0;
        int j = 0, k = height.length - 1;
        while (j < k) {
            int minHeight = Math.min(height[j], height[k]);
            int area = minHeight * (k - j);
            maxArea = Math.max(maxArea, area);
            while (j < k && height[j] <= minHeight) j++;
            while (j < k && height[k] <= minHeight) k--;
        }
        return maxArea;
    }

    public static void main (String[] args) {
        LC11ContainerWithMostWater lc11ContainerWithMostWater = new LC11ContainerWithMostWater();
        System.out.println(lc11ContainerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
