public class LC50Pow {

    public double myPow (double x, int n) {
        return binaryExp(x, (long) n);
    }

    double binaryExp (double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / binaryExp(x, -1 * n);
        }
        if (n % 2 == 0) return binaryExp(x * x, n / 2);
        else return x * binaryExp(x * x, (n - 1) / 2);
    }

    public static void main (String[] args) {
        LC50Pow lc50Pow = new LC50Pow();
        System.out.println(lc50Pow.myPow(2.00000, 10));
        System.out.println(lc50Pow.myPow(2.10000, 3));
        System.out.println(lc50Pow.myPow(2.00000, -2));
    }
}
