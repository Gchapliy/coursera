package week2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Ice {
    private static String[] ices = {"vanilla20", "pistachio", "strawberry", "vanilla20", "pistachio", "pistachio", "vanilla20"};

    public static void setIces(String[] ices) {
        Ice.ices = ices;
    }

    public static int findCountOfProducers() {
        Map<String, Integer> icesCounts = new HashMap<>();

        for (String ice : ices) {
            icesCounts.put(ice, icesCounts.get(ice) != null ? icesCounts.get(ice) + 1 : 1);
        }

        return icesCounts.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
    }

    public static void main(String[] args) {
        System.out.println(findCountOfProducers());
    }
}
