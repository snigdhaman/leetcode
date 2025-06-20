package arraysandhashing;

public class LC88MergeSortedArray {
    public void merge (int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                tmp[k] = nums1[i];
                i++;
            }
            else {
                tmp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            tmp[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            tmp[k] = nums2[j];
            j++;
            k++;
        }
        for (int idx = 0; idx < tmp.length; idx++) {
            nums1[idx] = tmp[idx];
        }
    }

    public static void main (String[] args) {
        LC88MergeSortedArray lc88MergeSortedArray = new LC88MergeSortedArray();
        lc88MergeSortedArray.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
