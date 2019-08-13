package sportProgramming.week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OlympiadFromFile {

    private static boolean fillOlympiadFromFile(Olympiad olympiad) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/sportProgramming.week2/resources/olympiadData2"))) {

            List<Integer> tasksTime = new ArrayList<>(1000);
            String[] s;

            while (br.ready()) {
                s = br.readLine().trim().split(" ");
                for (int i = 0; i < s.length; i++) {
                    tasksTime.add(Integer.parseInt(s[i]));
                }
            }

            olympiad.setTasksTime(tasksTime.stream().mapToInt(i -> i).toArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Olympiad olympiad = new Olympiad();

        if(fillOlympiadFromFile(olympiad)){
            olympiad.sortTasksByTime();
            olympiad.findAndShowMaxSolvedTasksAndMinPenalty();
        }
    }
}

