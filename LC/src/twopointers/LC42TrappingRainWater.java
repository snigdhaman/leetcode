package twopointers;

public class LC42TrappingRainWater {

    public int trap (int[] height) {
        int rainWater = 0;
        //Initialize maxHeight
        int maxLeft = height[0], maxRight = height[height.length - 1];
        //Initialize the 2 pointers
        int j = 0, k = height.length - 1;
        while (j <= k) {
            int currentWater = 0;
            if (maxLeft <= maxRight) {
                currentWater = maxLeft - height[j];
                maxLeft = Math.max(maxLeft, height[j]);
                j++;
            }
            else {
                currentWater = maxRight - height[k];
                maxRight = Math.max(maxRight, height[k]);
                k--;
            }
            if (currentWater > 0) {
                rainWater += currentWater;
            }
        }
        return rainWater;
    }

    public static void main(String[] args) {
        LC42TrappingRainWater lc42TrappingRainWater = new LC42TrappingRainWater();
//        System.out.println(lc42TrappingRainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(lc42TrappingRainWater.trap(new int[] {4,2,0,3,2,5}));
        System.out.println(lc42TrappingRainWater.trap(new int[] {5,5,1,7,1,1,5,2,7,6}));
    }
}
