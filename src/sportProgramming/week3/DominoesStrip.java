package sportProgramming.week3;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.math.BigInteger;

public class DominoesStrip {
    private int ans;
    private BigInteger[] d;

    public void findTilingsNumber(int n, boolean isEffective) {
        if (!isEffective)
            notEffectiveAlgorithm(0, n);
        else {
            d = new BigInteger[n + 1];
            effectiveAlgorithm(n);
        }

        System.out.println(d[n]);
        System.out.println(d[n].mod(new BigInteger("1000000000")));
    }

    private void effectiveAlgorithm(int n) {
        d[0] = new BigInteger("0");
        d[1] = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1].add(d[i - 2]);
        }
    }

    private void notEffectiveAlgorithm(int sum, int n) {
        if (sum > n)
            return;
        if (sum == n) {
            ans++;
            return;
        }

        notEffectiveAlgorithm(sum + 1, n);
        notEffectiveAlgorithm(sum + 2, n);
    }

    public static void main(String[] args) {
        new DominoesStrip().findTilingsNumber(100000, true);
    }
}
