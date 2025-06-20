package twopointers;

import java.util.*;

public class LC5ThreeSum {

    public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    //Triplet with 0 sum. Add to result
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    //Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    //Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                }
                else if (sum < 0) {
                    //Sum is less than 0 so increment j
                    j++;
                }
                else {
                    //sum is more than 0 so reduce k
                    k--;
                }
            }
        }
        return res;
    }

    public static void main (String[] args) {
        LC5ThreeSum lc5ThreeSum = new LC5ThreeSum();
        System.out.println(lc5ThreeSum.threeSum(new int[]{-3, -3, 0, 6}));
    }
}
