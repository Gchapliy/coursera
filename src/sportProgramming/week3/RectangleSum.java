package sportProgramming.week3;

public class RectangleSum {
    private static int[][] a = {
            {1, 3, 7, -1, 7, 11},
            {2, 6, 5, 1, 1, 3},
            {-3, 0, 2, 0, 3, 8},
            {5, 1, 3, 1, 4, 7},
            {6, 1, -2, 2, 1, 0},
    };

    private static int[] s = {1, 2, 3, 6, 5, 34, 34, 5, 56};
    private static int[] s1 = new int[s.length];

    public static void calculateSection() {
        s1[0] = 0;

        for (int i = 0; i <= s.length; i++) {

            s1[i] = s1[i - 1] + s[i];
        }
    }

}
