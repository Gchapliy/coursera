package sportProgramming.week3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LargestIncreasingSubsequence {
    private int[] sequence;
    private int[] s = {7, 1, 3, 2, 4};

    public LargestIncreasingSubsequence() {
        fillArray();
    }

    private void fillArray(){
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/sequence")))){

            while (br.ready()){
                String[] s = br.readLine().trim().split(" ");
                if(s.length == 1){
                    sequence = new int[Integer.parseInt(s[0])];
                    continue;
                }

                int quantity = 0;
                for (String number : s) {
                    sequence[quantity] = Integer.parseInt(number);
                    quantity ++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findLISSize(){
        int size = 0;



        return size;
    }

    public static void main(String[] args) {
        LargestIncreasingSubsequence largestIncreasingSubsequence = new LargestIncreasingSubsequence();
        System.out.println(largestIncreasingSubsequence.findLISSize());
    }
}
