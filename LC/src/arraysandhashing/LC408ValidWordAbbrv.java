package arraysandhashing;

public class LC408ValidWordAbbrv {

    public boolean validWordAbbreviation (String word, String abbr) {

        int wordIndex = 0;
        boolean startDigit = true;
        int currAbbr = 0;
        for (int index = 0; index < abbr.length(); index++) {
            char ch = abbr.charAt(index);
            if (Character.isDigit(ch)) {
                if (startDigit && ch == '0') {
                    return false;
                }
                currAbbr = currAbbr * 10 + Character.getNumericValue(ch);
                startDigit = false;
            }
            else {
                wordIndex += currAbbr;
                if (wordIndex >= word.length()) {
                    return false;
                }
                if (word.charAt(wordIndex) != abbr.charAt(index)) {
                    return false;
                }
                startDigit = true;
                currAbbr = 0;
                wordIndex++;
            }
        }
        wordIndex += currAbbr;
        return wordIndex == word.length();
    }


    public static void main (String[] args) {
        LC408ValidWordAbbrv lc408ValidWordAbbrv = new LC408ValidWordAbbrv();
        System.out.println(lc408ValidWordAbbrv.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(lc408ValidWordAbbrv.validWordAbbreviation("apple", "a2e"));
        System.out.println(lc408ValidWordAbbrv.validWordAbbreviation("a", "2"));
        System.out.println(lc408ValidWordAbbrv.validWordAbbreviation("hi", "1"));
    }
}
