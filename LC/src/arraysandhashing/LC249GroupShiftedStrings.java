package arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC249GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        //Traverse the list of strings & calculate the hash & store in map
        for (String str : strings) {
            String hash = getHash(str);
            if (map.containsKey(hash)) {
                map.get(hash).add(str);
            }
            else {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(hash, lst);
            }
        }
        //Traverse the map values & construct the result
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }

    String getHash (String s) {
        char firstChar = s.charAt(0);
        if (firstChar == 'a') {
            return s;
        }
        else {
            int diff = (firstChar - 97);
            char[] ch = s.toCharArray();
            char[] res = new char[ch.length];
            for (int i = 0; i < ch.length; i++) {
                int d = ch[i] - diff;
                if (d < 97) {
                    d += 26;
                }
                res[i] = (char) (d);
            }
            return String.valueOf(res);
        }
    }
}
