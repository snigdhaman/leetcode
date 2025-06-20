package arraysandhashing;

public class LC238ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        res[0] = prefix;
        for (int i = 0; i < nums.length - 1; i++) {
            prefix = prefix * nums[i];
            res[i + 1] = prefix;
        }

        int postfix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            postfix = postfix * nums[i];
            res[i - 1] = res[i - 1] * postfix;
        }

        return res;
    }

    public static void main(String[] args) {
        LC238ProductArrayExceptSelf lc238ProductArrayExceptSelf = new LC238ProductArrayExceptSelf();
    }
}
