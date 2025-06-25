package arraysandhashing;

public class LC824GoatLatin {
    public String toGoatLatin (String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char startChar = word.charAt(0);
            if (startChar == 'a' || startChar == 'e' || startChar == 'i' || startChar == 'o' || startChar == 'u' ||
                    startChar == 'A' || startChar == 'E' || startChar == 'I' || startChar == 'O' || startChar == 'U') {
                sb.append(word);
            }
            else {
                String s = word.substring(1);
                sb.append(s);
                sb.append(startChar);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
