package arraysandhashing;

public class LC14LongestCommonPrefix {
    public String longestCommonPrefix (String[] strs) {
        String prefix = "";
        if (strs.length == 0) {
            return prefix;
        }
        prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!prefix.isEmpty()) {
                if (strs[i].startsWith(prefix)) {
                    break;
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
