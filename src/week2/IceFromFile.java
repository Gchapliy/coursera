package week2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IceFromFile {

    public static boolean fillIce(Ice ice){
        try (Stream<String> stream = Files.lines(Paths.get("src/week2/resources/IceData2"))){
            List<String> ices = new ArrayList<>();

            stream.forEach(f -> ices.add(f.trim()));

            ice.setIces(ices.toArray(new String[0]));

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        Ice ice = new Ice();
        if(fillIce(ice)){
            System.out.println(ice.findCountOfProducers());
        }
    }
}
