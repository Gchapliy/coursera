package week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SheduleFromFile {

    private static boolean fillSheduleFromFile(Shedule shedule) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/week2/resources/sheduleData"))) {

            List<Integer> deadLines = new ArrayList<>();
            List<Integer> costs = new ArrayList<>();
            String[] s;

            while (br.ready()) {
                s = br.readLine().trim().split(" ");
                deadLines.add(Integer.parseInt(s[0]));
                costs.add(Integer.parseInt(s[1]));
            }

            shedule.setDeadLines(deadLines.stream().mapToInt(i -> i).toArray());
            shedule.setCosts(costs.stream().mapToInt(i -> i).toArray());
            shedule.setUsed(new boolean[deadLines.size()]);
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
        Shedule shedule = new Shedule();

        if (fillSheduleFromFile(shedule))
            System.out.println(shedule.getSumCosts());
    }
}
