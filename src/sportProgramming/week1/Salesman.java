package sportProgramming.week1;

import java.util.Arrays;

public class Salesman {

    static int n;
    static int[][] a = {
            {0, 41, 67, 0, 78, 5, 91, 4, 18, 67},
            {41, 0, 34, 69, 58, 45, 95, 2, 95, 99},
            {67, 34, 0, 24, 62, 81, 42, 53, 47, 35},
            {0, 69, 24, 0, 64, 27, 27, 92, 26, 94},
            {78, 58, 62, 64, 0, 61, 36, 82, 71, 3},
            {5, 45, 81, 27, 61, 0, 91, 21, 38, 11},
            {91, 95, 42, 27, 36, 91, 0, 16, 69, 22},
            {4, 2, 53, 92, 82, 21, 16, 0, 12, 33},
            {18, 95, 47, 26, 71, 38, 69, 12, 0, 73},
            {67, 99, 35, 94, 3, 11, 22, 33, 73, 0},
    };
    static int[] p;
    static boolean[] used;
    static int ans = Integer.MAX_VALUE;

    static void out() {
        System.out.println(ans);
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
        n = 10;
        used = new boolean[n];
        p = new int[n];
        p[0] = 0;
        rec(1, 0);
    }
}
