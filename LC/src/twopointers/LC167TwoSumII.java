package twopointers;

public class LC167TwoSumII {

    public int[] twoSum (int[] numbers, int target) {
        int j = 0, k = numbers.length - 1;
        int[] res = new int[2];
        while (j < k) {
            int sum = numbers[j] + numbers[k];
            if (sum == target) {
                res = new int[]{j + 1, k + 1};
                break;
            }
            else if (sum < target) j++;
            else k--;
        }
        return res;
    }

    public static void main(String[] args) {
        LC167TwoSumII lc167TwoSumII = new LC167TwoSumII();
    }
}
