package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC3LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
            else {
                if (startIndex <= map.get(ch)) {
                    startIndex = map.get(ch) + 1;
                }
                map.put(ch, i);
            }
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LC3LongestSubstringWithoutRepeatingChars lc3LongestSubstringWithoutRepeatingChars = new LC3LongestSubstringWithoutRepeatingChars();
        System.out.println(lc3LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lc3LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lc3LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lc3LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring(""));
    }
}
