package sportProgramming.week3;

import java.io.*;
import java.util.Arrays;

public class Rucksack {
    private int W = 12;
    private int n = 3;
    private int[] w = {0, 2, 5, 10};
    private int[] c = {0, 10, 20, 30};
    private int[][] d = new int[n + 1][W + 1];

    public void calculateMaxCost() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i + 1 < n && j + w[i + 1] <= W)
                    d[i + 1][j + w[i + 1]] = Math.max(d[i + 1][j + w[i + 1]], d[i][j] + c[i + 1]);
                if (i + 1 < n)
                    d[i + 1][j] = Math.max(d[i + 1][j], d[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(d));
    }

    public int calculateMaxCost2() {

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                d[i][j] = d[i - 1][j];
                if (j - w[i] >= 0) {
                    System.out.println(d[i][j] + " " + (d[i - 1][j - w[i]] + c[i]));
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + c[i]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(d));
        return d[n][W];
    }

    public void fillFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/rucksack")))) {

            int counter = 0;
            while (br.ready()) {
                String[] s = br.readLine().trim().split(" ");
                if (counter == 0) {
                    n = Integer.parseInt(s[0]);
                    W = Integer.parseInt(s[1]);
                    w = new int[n + 1];
                    c = new int[n + 1];
                    d = new int[n + 1][W + 1];
                } else {
                    w[counter] = Integer.parseInt(s[0]);
                    c[counter] = Integer.parseInt(s[1]);
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Rucksack rucksack = new Rucksack();
        rucksack.fillFromFile();
        System.out.println(rucksack.calculateMaxCost2());
    }
}
