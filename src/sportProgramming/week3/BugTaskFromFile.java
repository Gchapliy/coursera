package sportProgramming.week3;

import java.io.*;

public class BugTaskFromFile {
    private BugTask bugTask = new BugTask();
    private int[][] arr;

    private void fillArray(){
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/sportProgramming/week3/resources/bugTask1")))){
            int row = 0;
            int column;

            while (br.ready()){
                String[] s = br.readLine().trim().split(" ");
                if(s.length == 2){
                    arr = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
                    continue;
                }

                column = 0;
                for (String number : s) {
                    arr[row][column] = Integer.parseInt(number);
                    column ++;
                }

                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findOptimalPath(){
        fillArray();
        bugTask.updateData(arr);
        bugTask.findOptimalPath();
    }

    public static void main(String[] args) {
        BugTaskFromFile bugTaskFromFile = new BugTaskFromFile();
        bugTaskFromFile.findOptimalPath();
    }
}
