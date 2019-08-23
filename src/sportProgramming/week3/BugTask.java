package sportProgramming.week3;

import edu.princeton.cs.algs4.StdOut;

public class BugTask {
    private static int[][] a = {
            {1, 4, 1, 2, 3},
            {2, 3, 2, 1, 4},
            {1, 1, 1, 2, 4},
            {2, 5, 1, 7, 1},
    };
    private static int[][] d = new int[a.length][a[0].length];
    private static int[][] p = new int[a.length][a[0].length];

    public static void findOptimalPath() {
        int n = a.length;
        int m = a[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = a[i][j];
                if (i > 0 && d[i - 1][j] + a[i][j] > d[i][j]) {
                    d[i][j] = d[i - 1][j] + a[i][j];
                    p[i][j] = 0;
                }
                if (j > 0 && d[i][j - 1] + a[i][j] > d[i][j]) {
                    d[i][j] = d[i][j - 1] + a[i][j];
                    p[i][j] = 1;
                }
            }

            System.out.println(d[n - 1][m - 1]);
            recout(n - 1, m - 1);
        }
    }

    private static void recout(int i, int j){
        if(i == 0 && j == 0)
            return;
        if(p[i][j] == 0){
            recout(i - 1, j);
            System.out.println("D");
        }
        if(p[i][j] == 1){
            recout(i, j - 1);
            System.out.println("R");
        }
    }

    public static void main(String[] args) {
        findOptimalPath();
    }
}
