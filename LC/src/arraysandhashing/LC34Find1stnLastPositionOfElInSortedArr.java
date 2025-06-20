package arraysandhashing;

public class LC34Find1stnLastPositionOfElInSortedArr {
    public int[] searchRange(int[] nums, int target) {
        int index = findIndex(nums, target);
        if (index == -1) return new int[] {-1, -1};

        int left = index, right = index;
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        while (left >= 0 && nums[left] == target) {
            res[0] = left;
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            res[1] = right;
            right++;
        }
        return res;
    }

    int findIndex (int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
