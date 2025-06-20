package arraysandhashing;

public class LC977SquaresOfSortedArrays {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            }
            else {
                square = nums[left];
                left++;
            }
            square *= square;
            res[i] = square;
        }
        return res;
    }
}
