package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC76MinimumWindowSubstring {

    public String minWindow (String s, String t) {
        String res = "";
        int minLength = Integer.MAX_VALUE;
        if (t.length() > s.length()) {
            return res;
        }

        //Create freqMap
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int startIndex = 0, endIndex = 0, count = 0;

        while (endIndex < s.length()) {
            char endChar = s.charAt(endIndex);

            if (freqMap.containsKey(endChar)) {
                freqMap.put(endChar, freqMap.get(endChar) - 1);
                if (freqMap.get(endChar) >= 0) count++;
            }

            while (count == t.length()) {
                String subString = s.substring(startIndex, endIndex + 1);
                if (subString.length() < minLength) {
                    minLength = subString.length();
                    res = subString;
                }
                char startChar = s.charAt(startIndex);
                if (freqMap.containsKey(startChar)) {
                    freqMap.put(startChar, freqMap.get(startChar) + 1);
                    if (freqMap.get(startChar) > 0) count--;
                }
                startIndex++;
            }
            endIndex++;
        }
        return res;
    }

    public static void main (String[] args) {
        LC76MinimumWindowSubstring lc76MinimumWindowSubstring = new LC76MinimumWindowSubstring();
        System.out.println(lc76MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(lc76MinimumWindowSubstring.minWindow("a", "a"));
        System.out.println(lc76MinimumWindowSubstring.minWindow("a", "aa"));
    }
}
