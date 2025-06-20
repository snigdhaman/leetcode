package arraysandhashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MinWindowSubString {
    public String minWindow (String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        char[] arr = t.toCharArray();
        for (char ch : arr) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int start = 0, end = 0;
        String res = "";
        while (end < charArray.length) {
            if (freqMap.containsKey(charArray[end])) {
                map.put(charArray[end], map.getOrDefault(charArray[end], 0) + 1);
            }
            if (end - start >= t.length() && freqMap.size() == map.size()) {
                boolean matches = true;
                for (Character key : freqMap.keySet()) {
                    if (freqMap.get(key) > map.get(key)) {
                        matches = false;
                        break;
                    }
                }
                if (matches) {
                    if (res.isEmpty() || res.length() > end - start) {
                        res = s.substring(start, end + 1);
                    }
                }
            }
            end++;
            if (freqMap.size() == map.size() && freqMap.values().stream().sorted().collect(Collectors.toList()).equals(map.values().stream().sorted().collect(Collectors.toList()))) {
                map.put(charArray[start], map.get(charArray[start]) - 1);
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinWindowSubString minWindowSubString = new MinWindowSubString();
        System.out.println(minWindowSubString.minWindow("ADOBECODEBANC", "ABC"));
    }
}
