package sportProgramming.week3;

import java.math.BigInteger;

public class BinomialCoefficients {
    public static BigInteger calculate(int n, int k) {
        BigInteger res = new BigInteger("1");

        for (int i = n - k + 1; i <= n; ++i)
            res = res.multiply(new BigInteger(Integer.toString(i)));
        for (int i = 2; i <= k; ++i)
            res = res.divide(new BigInteger(Integer.toString(i)));

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate(50, 20));
    }
}
