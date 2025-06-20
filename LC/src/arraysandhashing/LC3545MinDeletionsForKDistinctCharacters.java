package arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC3545MinDeletionsForKDistinctCharacters {

    public int minDeletion (String s, int k) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(charArray[i], freqMap.getOrDefault(charArray[i], 0) + 1);
        }

        List<Integer> values = new ArrayList<>(freqMap.values());
        values = values.stream().sorted().collect(Collectors.toList());
        int res = 0, idx = 0;
        int dist = values.size();
        while (dist > k) {
            res += values.get(idx);
            dist--;
            idx++;
        }
        return res;
    }

    public static void main (String[] args) {
        LC3545MinDeletionsForKDistinctCharacters lc3545MinDeletionsForKDistinctCharacters = new LC3545MinDeletionsForKDistinctCharacters();
//        System.out.println(lc3545MinDeletionsForKDistinctCharacters.minDeletion("abc", 2));
        System.out.println(lc3545MinDeletionsForKDistinctCharacters.minDeletion("wund", 1));
    }
}
