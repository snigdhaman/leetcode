package arraysandhashing;

public class LC528RandomPickWithWeight {

    int[] nums;
    int[] cumulativeSum;
    int sum;
    public LC528RandomPickWithWeight (int[] w) {
        nums = w;
        sum = 0;
        cumulativeSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cumulativeSum[i] = sum;
        }
    }

    public int pickIndex () {
        double target = Math.random() * sum;

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > cumulativeSum[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public static void main (String[] args) {
        LC528RandomPickWithWeight lc528RandomPickWithWeight = new LC528RandomPickWithWeight(new int[]{1});
        System.out.println(lc528RandomPickWithWeight.pickIndex());
//        for (int i = 0; i < 100; i++) {
//            LC528RandomPickWithWeight lc528RandomPickWithWeight = new LC528RandomPickWithWeight(new int[]{1, 3});
//            System.out.println(lc528RandomPickWithWeight.pickIndex());
//        }
    }

}
