package sportProgramming.week3;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.Arrays;

public class LargestCommonSubsequence {
    private int[] a = {0, 3, 2, 4, 2, 1, 7, 6};
    private int[] b = {0, 4, 2, 5, 3, 1, 6, 5, 2, 3};
    private int[][] d = new int[a.length][b.length];

    private int calculateSizeLargestSubsequence() {
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                if (a[i - 1] == b[j - 1])
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - 1] + 1);
            }
        }
        return d[a.length - 1][b.length - 1];
    }

    public void fillFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/sequence2")))) {
            boolean flag = false;
            boolean fa = true;
            while (br.ready()) {
                String[] s = br.readLine().trim().split(" ");
                if (s.length == 1 && flag) {
                    b = new int[Integer.parseInt(s[0])];
                } else if (s.length == 1 && !flag) {
                    a = new int[Integer.parseInt(s[0])];
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LargestCommonSubsequence largestCommonSubsequence = new LargestCommonSubsequence();
        System.out.println(largestCommonSubsequence.calculateSizeLargestSubsequence());
    }
}
