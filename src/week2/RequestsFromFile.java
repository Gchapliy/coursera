package week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestsFromFile {

    private static boolean fillRequestsFromFile(Requests requests) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/week2/resources/requestsData"))) {

            List<Integer> leftLimit = new ArrayList<>();
            List<Integer> rightLimit = new ArrayList<>();
            String[] s;

            while (br.ready()) {
                s = br.readLine().trim().split(" ");
                leftLimit.add(Integer.parseInt(s[0]));
                rightLimit.add(Integer.parseInt(s[1]));
            }

            requests.setLeftLimit(leftLimit.stream().mapToInt(i -> i).toArray());
            requests.setRightLimit(rightLimit.stream().mapToInt(i -> i).toArray());
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
        Requests requests = new Requests();

        if (fillRequestsFromFile(requests))
            System.out.println(requests.findMaxRequestsCountToAccess());
    }
}
