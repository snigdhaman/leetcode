package arraysandhashing;

import java.util.HashMap;
import java.util.Map;

public class LC791CustomSortString {

    public String customSortString (String order, String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        char[] arr = s.toCharArray();
        for (char ch : arr) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        char[] orderArr = order.toCharArray();
        for (char ch : orderArr) {
            if (freqMap.get(ch) != null && freqMap.get(ch) != 0) {
                int count = freqMap.get(ch);
                while (count > 0) {
                    sb.append(ch);
                    freqMap.put(ch, freqMap.get(ch) - 1);
                    count--;
                }
            }
        }
        for (Character ch : freqMap.keySet()) {
            if (freqMap.get(ch) != null) {
                for (int i = 0; i < freqMap.get(ch); i++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        LC791CustomSortString lc791CustomSortString = new LC791CustomSortString();
//        System.out.println(lc791CustomSortString.customSortString("cba", "abcd"));
//        System.out.println(lc791CustomSortString.customSortString("bcafg", "abcd"));
        System.out.println(lc791CustomSortString.customSortString("kqep", "pekeq"));
    }

}
