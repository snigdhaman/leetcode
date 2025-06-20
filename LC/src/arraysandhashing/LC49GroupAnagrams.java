package arraysandhashing;

import java.util.*;

public class LC49GroupAnagrams {

    public List<List<String>> groupAnagrams (String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main (String[] args) {
        LC49GroupAnagrams anagrams = new LC49GroupAnagrams();
        System.out.println(anagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}