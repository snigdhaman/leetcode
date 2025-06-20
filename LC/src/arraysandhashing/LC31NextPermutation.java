package arraysandhashing;

public class LC31NextPermutation {

    public int[] nextPermutation (int[] nums) {
        int decreasingIndex = 0;
        boolean decreasing = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                decreasingIndex = i - 1;
                decreasing = true;
                break;
            }
        }
        int swapIndex = nums.length - 1;
        if (decreasing) {
            for (int i = decreasingIndex + 1; i < nums.length; i++) {
                if (nums[decreasingIndex] >= nums[i]) {
                    swapIndex = i - 1;
                    break;
                }
            }
            int n = nums[decreasingIndex];
            nums[decreasingIndex] = nums[swapIndex];
            nums[swapIndex] = n;
        }
        int startIndex = decreasing ? decreasingIndex + 1 : decreasingIndex;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int n = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = n;
            startIndex++;
            endIndex--;
        }
        return nums;
    }

    public static void main (String[] args) {
        LC31NextPermutation lc31NextPermutation  = new LC31NextPermutation();
        System.out.println(lc31NextPermutation.nextPermutation(new int[] {1,5,1}));
        System.out.println(lc31NextPermutation.nextPermutation(new int[] {3,2,1}));
        System.out.println(lc31NextPermutation.nextPermutation(new int[] {1,3,2}));
        System.out.println(lc31NextPermutation.nextPermutation(new int[] {1,2,3}));
        System.out.println(lc31NextPermutation.nextPermutation(new int[] {1,2,4,9,8,7,6,5,3}));
    }

}
