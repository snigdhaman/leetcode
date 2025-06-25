package arraysandhashing;

public class LC1004MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int maxWindow = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                count++;
            }
            int currWindow = right - left;
            if (currWindow >= count + k) {
                if (nums[left] == 1) {
                    count--;
                }
                left++;
            }
            else {
                maxWindow = Math.max(maxWindow, currWindow + 1);
            }
            right++;
        }
        return maxWindow;
    }

    public static void main (String[] args) {
        LC1004MaxConsecutiveOnesIII lc1004MaxConsecutiveOnesIII = new LC1004MaxConsecutiveOnesIII();
        System.out.println(lc1004MaxConsecutiveOnesIII.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(lc1004MaxConsecutiveOnesIII.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
