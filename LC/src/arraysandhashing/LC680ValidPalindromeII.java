package arraysandhashing;

public class LC680ValidPalindromeII {

    public boolean validPalindrome (String s) {

        int left = 0, right = s.length() - 1, mismatchCount = 0;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                String skipLeftChar = s.substring(0, left) + s.substring(left + 1);
                String skipRightChar = s.substring(0, right) + s.substring(right + 1);
                return (skipLeftChar.equals(new StringBuilder(skipLeftChar).reverse().toString()) ||
                    skipRightChar.equals(new StringBuilder(skipRightChar).reverse().toString()));
            }
            left++;
            right--;
        }
        return true;
    }


//    public boolean validPalindrome (String s) {
//
//        int left = 0, right = s.length() - 1, mismatchCount = 0;
//        while (left < right) {
//            char leftChar = s.charAt(left);
//            char rightChar = s.charAt(right);
//            if (leftChar == rightChar) {
//                left++;
//                right--;
//            }
//            else if (s.charAt(left + 1) == rightChar) {
//                mismatchCount++;
//                left++;
//            }
//            else if (leftChar == s.charAt(right - 1)) {
//                mismatchCount++;
//                right--;
//            }
//            else {
//                return false;
//            }
//            if (mismatchCount > 1) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main (String[] args) {
        LC680ValidPalindromeII lc680ValidPalindromeII = new LC680ValidPalindromeII();
        System.out.println(lc680ValidPalindromeII.validPalindrome("aba"));
        System.out.println(lc680ValidPalindromeII.validPalindrome("abca"));
        System.out.println(lc680ValidPalindromeII.validPalindrome("abc"));
        System.out.println(lc680ValidPalindromeII.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
