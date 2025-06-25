package arraysandhashing;

public class LC670MaximumSwap {
    public int maximumSwap (int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int n = ch.length;
        //Store the index of the maximum no. of the right of current index
        int[] maxRightIndex = new int[n];

        maxRightIndex[n - 1] = n - 1;
        //Get all indexes of max numbers to right of current index
        for (int i = n - 2; i >= 0; i--) {
            maxRightIndex[i] = ch[i] > ch[maxRightIndex[i + 1]] ? i : maxRightIndex[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (ch[i] < ch[maxRightIndex[i]]) {
                char tmp = ch[i];
                ch[i] = ch[maxRightIndex[i]];
                ch[maxRightIndex[i]] = tmp;
                return Integer.valueOf(new String(ch));
            }
        }
        return num;
    }
}
