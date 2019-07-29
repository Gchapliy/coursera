package week1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Salesman {

    static int n;
    static int[][] a = {
            {0, 1, 4, 6},
            {1, 0, 5, 2},
            {4, 5, 0, 3},
            {6, 2, 3, 0},
    };
    static int[] p;
    static boolean[] used;
    static int ans = Integer.MAX_VALUE;

    static void out() {
        System.out.println(count());
        System.out.println(Arrays.toString(p));
    }

    static int count() {
        int count = 0;

        for (int i = 0; i < p.length; i++) {
            if (i < p.length - 1) count += a[p[i]][p[i + 1]];
            else count += a[p[i]][0];
        }

        return count;
    }

    static void rec(int idx, int len) {
        if (len >= ans)
            return;
        if (idx == n) {
            int count = count();
            ans = count < ans ? count : ans;
            out();
            return;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (used[i])
                continue;
            p[idx] = i;
            used[i] = true;
            rec(idx + 1, len + a[p[idx - 1]][i]);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        n = 4;
        used = new boolean[n];
        p = new int[n];
        p[0] = 0;
        rec(1, 0);

    }
}
