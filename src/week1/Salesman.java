package week1;

import java.util.Arrays;
import java.util.List;

public class Salesman {

    static int n;
    static int[][] a = { {0, 0}, {0, 1}, {0, 4}, {0, 6},
                         {1, 0}, {1, 1}, {1, 4}, {1, 6},
                         {2, 0}, {2, 1}, {2, 4}, {2, 6},
                         {3, 0}, {3, 1}, {3, 4}, {3, 6},
    };
    static int[] p;
    static boolean[] used;
    static int ans = Integer.MAX_VALUE;

    static void out() {

    }

    static int count() {

        return 0;
    }

    static void rec(int idx, int len) {
        if (len >= ans)
            return;
        if (idx == n) {
            int temp = count();
            ans = ans < temp ? ans : temp;
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
       /* n = 4;
        used = new boolean[n];
        p[0] = 0;
        rec(1, 0);*/
        System.out.println(a[0][1]);
    }
}
