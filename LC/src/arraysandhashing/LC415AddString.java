package arraysandhashing;

public class LC415AddString {
    public String addStrings(String num1, String num2) {
        String res = "";
        int carryOver = 0;
        char[] num1Arr = num1.toCharArray(), num2Arr = num2.toCharArray();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? Character.getNumericValue(num1Arr[i]) : 0;
            int n2 = j >= 0 ? Character.getNumericValue(num2Arr[j]) : 0;
            int sum = carryOver + n1 + n2;
            if (sum > 9) {
                carryOver = 1;
                sum = sum - 10;
            }
            else {
                carryOver = 0;
            }
            res = String.valueOf(sum) + res;
            i--;
            j--;
        }
        if (carryOver != 0) {
            res = carryOver + res;
        }
        return res;
    }

    public static void main(String[] args) {
        LC415AddString lc415AddString = new LC415AddString();
        System.out.println(lc415AddString.addStrings("11", "123"));
    }
}
