package arraysandhashing;

public class LC1570DotProductOfSparseVectors {
    private int[] nums;
    LC1570DotProductOfSparseVectors (int[] nums) {
        this.nums = nums;
    }

    public int[] getNums () {
        return this.nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(LC1570DotProductOfSparseVectors vec) {
        int[] nums2 = vec.getNums();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * nums2[i];
        }
        return sum;
    }


    /**
     * Below is supposed to be the correct answer
     */

//    List<int[]> val;
//    SparseVector(int[] nums) {
//        val = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            val.add(new int[] {i, nums[i]});
//        }
//    }
//
//    // Return the dotProduct of two sparse vectors
//    public int dotProduct(SparseVector vec) {
//        List<int[]> val2 = vec.val;
//        int sum = 0, i = 0, j = 0;
//        while (i < val.size() && j < val2.size()) {
//            if (val.get(i)[0] == val2.get(i)[0]) {
//                sum += val.get(i)[1] * val2.get(i)[1];
//                i++;
//                j++;
//            }
//            else if (val.get(i)[0] < val2.get(j)[0]) {
//                i++;
//            }
//            else {
//                j++;
//            }
//        }
//        return sum;
//    }
}
