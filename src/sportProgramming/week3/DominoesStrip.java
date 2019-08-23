package sportProgramming.week3;

public class DominoesStrip {
    private int ans;
    private long[] d;

    public void findTilingsNumber(int n, boolean isEffective) {
        if (!isEffective)
            notEffectiveAlgorithm(0, n);
        else {
            d = new long[n + 1];
            effectiveAlgorithm(n);
        }

        System.out.println(ans);
    }

    private void effectiveAlgorithm(int n) {
        d[0] = d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
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
        new DominoesStrip().findTilingsNumber(10, false);
    }
}
