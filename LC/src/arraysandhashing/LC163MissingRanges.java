package arraysandhashing;

import java.util.ArrayList;
import java.util.List;

public class LC163MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(new ArrayList<>(List.of(lower, upper)));
            return res;
        }

        if (nums[0] != lower) {
            res.add(new ArrayList<>(List.of(lower, nums[0] - 1)));
        }
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[j] != nums[i] + 1) {
                res.add(new ArrayList<>(List.of(nums[i] + 1, nums[j] - 1)));
            }
        }
        if (nums[nums.length - 1] != upper) {
            res.add(new ArrayList<>(List.of(nums[nums.length - 1] + 1, upper)));
        }
        return res;
    }
}
