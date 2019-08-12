package week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BackPackFromFile {

    public static boolean fillBackPackFromFile(BackPack backPack) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/week2/resources/backPackData"))) {

            List<Integer> weights = new ArrayList<>();
            List<Integer> costs = new ArrayList<>();
            String[] s;

            while (br.ready()) {
                s = br.readLine().trim().split(" ");

                weights.add(Integer.parseInt(s[0]));
                costs.add(Integer.parseInt(s[1]));
            }

            backPack.setWeights(weights.stream().mapToInt(i -> i).toArray());
            backPack.setCosts(costs.stream().mapToInt(i -> i).toArray());

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
        BackPack backPack = new BackPack();

        if(fillBackPackFromFile(backPack))
            backPack.sortThingsByKoef();
            System.out.println(backPack.findMaxCost());
    }
}
