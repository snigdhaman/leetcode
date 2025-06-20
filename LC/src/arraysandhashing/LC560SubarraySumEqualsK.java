package arraysandhashing;

import java.util.HashMap;
import java.util.Map;

public class LC560SubarraySumEqualsK {

//    public int subarraySum (int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    count++;
//                }
////                else if (sum > k) break;
//            }
//        }
//        return count;
//    }

    public int subarraySum (int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int sum = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int prefixSum = sum - k;
            if (prefixMap.containsKey(prefixSum)) {
                res += prefixMap.get(prefixSum);
            }
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main (String[] args) {
        LC560SubarraySumEqualsK lc560SubarraySumEqualsK = new LC560SubarraySumEqualsK();
        System.out.println(lc560SubarraySumEqualsK.subarraySum(new int[] {1,1,1}, 2));
        System.out.println(lc560SubarraySumEqualsK.subarraySum(new int[] {1,-1,0}, 0));
    }

}
