package sportProgramming.week3;

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
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/sequence3")))) {
            boolean isA = true;
            boolean isB = false;
            int aCounter = 0;
            int bCounter = 0;

            while (br.ready()) {
                String[] s = br.readLine().trim().split(" ");
                if (s.length == 1 && isB) {
                    b = new int[Integer.parseInt(s[0])];
                    isB = false;
                    isA = true;
                } else if (s.length == 1 && isA) {
                    a = new int[Integer.parseInt(s[0])];
                    isB = true;
                    isA = false;
                } else if(s.length > 1 && !isA){
                    for (int i = 0; i < s.length; i++) {
                        a[aCounter] = Integer.parseInt(s[i]);
                        aCounter++;
                    }
                } else if(s.length > 1 && !isB){
                    for (int i = 0; i < s.length; i++) {
                        b[bCounter] = Integer.parseInt(s[i]);
                        bCounter++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        d = new int[a.length][b.length];
       // System.out.println("a - " + Arrays.toString(a));
       // System.out.println("b - " + Arrays.toString(b));
    }

    public static void main(String[] args) {
        LargestCommonSubsequence largestCommonSubsequence = new LargestCommonSubsequence();
        largestCommonSubsequence.fillFromFile();
        System.out.println(largestCommonSubsequence.calculateSizeLargestSubsequence());
    }
}
