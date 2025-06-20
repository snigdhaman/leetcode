package arraysandhashing;

public class LC1004MaxConsecutiveOnesIII {

    public int longestOnes (int[] nums, int k) {
        int start = 0, end = 0, count = 0, maxLength = Integer.MIN_VALUE;

        while (end < nums.length) {
            if (nums[end] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }

    public static void main (String[] args) {
        LC1004MaxConsecutiveOnesIII lc1004MaxConsecutiveOnesIII = new LC1004MaxConsecutiveOnesIII();
        System.out.println(lc1004MaxConsecutiveOnesIII.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(lc1004MaxConsecutiveOnesIII.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
