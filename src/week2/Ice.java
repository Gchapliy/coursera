package week2;

import java.util.*;

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

    public static int findCountOfProducersV2() {
        int maxProducers = 1;

        for (int i = 0; i < ices.length - 1; i++) {
            for (int j = i + 1; j < ices.length; j++) {
                 if (ices[j].equalsIgnoreCase(ices[j - 1])) {
                    maxProducers++;

                    break;
                } else if (ices[j].equalsIgnoreCase(ices[i])) {
                    maxProducers++;
                }
            }
        }

        return maxProducers;
    }

    public static void main(String[] args) {
        System.out.println(findCountOfProducersV2());
    }
}
