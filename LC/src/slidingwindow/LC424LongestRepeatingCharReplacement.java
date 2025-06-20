package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharReplacement {

    public int characterReplacement (String s, int k) {
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int maxMostFreqCharCountInWindow = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxMostFreqCharCountInWindow = Math.max(maxMostFreqCharCountInWindow, map.get(ch));

            if (!((endIndex - startIndex) < (maxMostFreqCharCountInWindow + k))) {
                map.put(s.charAt(startIndex), map.get(s.charAt(startIndex)) - 1);
                startIndex++;
            }
            maxLength = Math.max(maxLength, (endIndex - startIndex) + 1);
        }
        return maxLength;
    }

//    public int characterReplacement (String s, int k) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        int maxLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int currentDiff = k;
//            int startIndex = i + 1;
//            int currentLength = 1;
//            while (startIndex < s.length()) {
//                if (s.charAt(i) != s.charAt(startIndex)) {
//                    currentDiff--;
//                }
//                if (currentDiff >= 0) {
//                    currentLength++;
//                }
//                maxLength = Math.max(maxLength, currentLength);
//                startIndex++;
//            }
//            int diff = Math.min(i, currentDiff);
//            maxLength = Math.max(maxLength, currentLength + diff);
//        }
//        return maxLength;
//    }


    public static void main(String[] args) {
        LC424LongestRepeatingCharReplacement lc424LongestRepeatingCharReplacement = new LC424LongestRepeatingCharReplacement();
        System.out.println(lc424LongestRepeatingCharReplacement.characterReplacement("ABAB", 2));
        System.out.println(lc424LongestRepeatingCharReplacement.characterReplacement("AABABBA", 1));
        System.out.println(lc424LongestRepeatingCharReplacement.characterReplacement("ABBB", 2));
    }
}
