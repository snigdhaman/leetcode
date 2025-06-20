package arraysandhashing;


public class LC1539KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) {
                k++;
            }
            else {break;}
        }
        return k;
    }

    public static void main(String[] args) {
        LC1539KthMissingPositiveNumber lc1539KthMissingPositiveNumber = new LC1539KthMissingPositiveNumber();
        System.out.println(lc1539KthMissingPositiveNumber.findKthPositive(new int[] {2,3,4,7,11}, 5));
        System.out.println(lc1539KthMissingPositiveNumber.findKthPositive(new int[] {1,2,3,4}, 2));
    }
}
