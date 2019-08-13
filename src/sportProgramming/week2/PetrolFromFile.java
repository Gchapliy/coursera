package sportProgramming.week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetrolFromFile {

    public static boolean fillPetrolFromFile(Petrol petrol) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/sportProgramming.week2/resources/petrolData"))) {

            int fullTankDistance = 0;
            int distanceBetweenCities = 0;
            List<Integer> distancesToGasStations = new ArrayList<>();
            String[] s;

            while (br.ready()) {
                s = br.readLine().trim().split(" ");
                if(s.length == 3){
                    distanceBetweenCities = Integer.parseInt(s[1]);
                    fullTankDistance = Integer.parseInt(s[2]);
                }
                else {
                    Arrays.stream(s).forEach(f -> distancesToGasStations.add(Integer.parseInt(f)));
                }
            }

            petrol.setFullTankDistance(fullTankDistance);
            petrol.setDistanceBetweenCities(distanceBetweenCities);
            petrol.setDistancesToGasStations(distancesToGasStations.stream().mapToInt(i -> i).toArray());

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
        Petrol petrol = new Petrol();

        if(fillPetrolFromFile(petrol)){
            System.out.println(petrol.calculateGasStationsCount(false));
        }
    }
}
