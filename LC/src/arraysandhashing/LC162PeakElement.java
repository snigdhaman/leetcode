package arraysandhashing;

public class LC162PeakElement {

    public int findPeakElement (int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int leftPrefix = left == 0 ? Integer.MIN_VALUE : nums[left - 1];
            int leftPostfix = left == nums.length - 1 ? Integer.MIN_VALUE : nums[left + 1];
            if (nums[left] > leftPrefix && nums[left] > leftPostfix) {
                return left;
            }
            left++;
            int rightPrefix = right == 0 ? Integer.MIN_VALUE : nums[right - 1];
            int rightPostfix = right == nums.length - 1 ? Integer.MIN_VALUE : nums[right + 1];
            if (nums[right] > rightPrefix && nums[right] > rightPostfix) {
                return right;
            }
            right--;
        }
        return 0;
    }

    public static void main(String[] args) {
        LC162PeakElement lc162PeakElement = new LC162PeakElement();
        System.out.println(lc162PeakElement.findPeakElement(new int[] {1,2,3,1}));
        System.out.println(lc162PeakElement.findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }

}
