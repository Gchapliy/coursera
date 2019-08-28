package sportProgramming.week3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestIncreasingSubsequence {
    private int[] sequence = {7, 1, 3, 2, 4};
    private int LISCount;
    private Map<Integer, Integer> lises = new HashMap<>();

    public LargestIncreasingSubsequence() {

        //fillArray();
    }

    public int findLISSize() {

        if (sequence.length == 1) {
            return 1;
        }

        int lengthOfSubsequence[] = new int[sequence.length];
        Arrays.fill(lengthOfSubsequence, 1);

        for (int i = 1; i < sequence.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    if (lengthOfSubsequence[i] <= lengthOfSubsequence[j]) {
                        lengthOfSubsequence[i] = lengthOfSubsequence[j] + 1;
                    }
                }
            }
        }

        int maximum = 0;

        System.out.println(Arrays.toString(lengthOfSubsequence));
        for (int length : lengthOfSubsequence) {
            lises.put(length, lises.containsKey(length) ? lises.get(length) + 1 : 1);
            maximum = Math.max(maximum, length);
        }

        LISCount = lises.get(maximum);

        return maximum;
    }

    public void fillArray() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/sequence")))) {

            while (br.ready()) {
                String[] s = br.readLine().trim().split(" ");
                if (s.length == 1) {
                    this.sequence = new int[Integer.parseInt(s[0])];
                    continue;
                }

                int quantity = 0;
                for (String number : s) {
                    this.sequence[quantity] = Integer.parseInt(number);
                    quantity++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LargestIncreasingSubsequence largestIncreasingSubsequence = new LargestIncreasingSubsequence();
        System.out.println(largestIncreasingSubsequence.findLISSize());
        System.out.println(largestIncreasingSubsequence.LISCount);
    }
}
