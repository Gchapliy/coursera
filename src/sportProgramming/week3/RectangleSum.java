package sportProgramming.week3;

import java.io.*;
import java.util.Arrays;

public class RectangleSum {
    private int[][] a = {
            {1, 3, 7, -1, 7, 11},
            {2, 6, 5, 1, 1, 3},
            {-3, 0, 2, 0, 3, 8},
            {5, 1, 3, 1, 4, 7},
            {6, 1, -2, 2, 1, 0},
    };

    private int[][] q = {
            {2, 3, 2, 3},
            {1, 1, 5, 6},
            {3, 5, 3, 6},
    };

    private int[][] s;

    public void fillDataFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/rectangle")))){
            int valuesCounter = 0;
            int queriesCounter = 0;

            while (br.ready()){
                String[] s = br.readLine().trim().split(" ");

                if(s.length == 2){
                    a = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
                } else if(s.length == 1){
                    q = new int[Integer.parseInt(s[0])][4];
                } else if(s.length > 4){
                    for (int i = 0; i < s.length; i++) {
                        a[valuesCounter][i] = Integer.parseInt(s[i]);
                    }
                    valuesCounter++;
                } else if(s.length == 4){
                    for (int i = 0; i < 4; i++) {
                        q[queriesCounter][i] = Integer.parseInt(s[i]);
                    }
                    queriesCounter++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void precalculationSections(){
        s = new int[a.length][a[0].length + 1];

        for (int i = 0; i < a.length; i++) {
            s[i][0] = 0;
            for (int j = 1; j < a[0].length + 1; j++) {
                s[i][j] = s[i][j - 1] + a[i][j - 1];
            }
        }
    }

    public void calculateQueries() {

        precalculationSections();
        int allSum = 0;
        for (int i = 0; i < q.length; i++) {
            int sum = 0;

            for (int j = q[i][0] - 1; j <= q[i][1] - 1; j++) {
                int left = s[j][q[i][2] - 1];
                int right = s[j][q[i][3]];
                sum += right - left;
            }
            allSum += sum;
            //System.out.println("sum in row = " + sum);
        }

        System.out.println("all sum = " + allSum);
    }

    public static void main(String[] args) {
        RectangleSum rectangleSum = new RectangleSum();
        rectangleSum.fillDataFromFile();
        rectangleSum.calculateQueries();
    }

}
