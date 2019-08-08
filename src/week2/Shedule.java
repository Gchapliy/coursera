package week2;

public class Shedule {
    private static int[] deadLines = {2, 2, 1, 7, 5, 5, 4, 7, 7, 5};
    private static int[] costs = {92, 80, 66, 55, 55, 38, 35, 19, 16, 2};

    private static boolean[] used = new boolean[deadLines.length + 1];

    public static long getSumCosts(){
        long sum = 0;

        for (int i = 0; i < deadLines.length; i++) {
            int k = deadLines[i];
            while (k >= 1 && used[k])
                k--;
            if(k == 0)
                continue;
            used[k] = true;
            sum += costs[i];
        }

        return sum;
    }

    public static void setDeadLines(int[] deadLines) {
        Shedule.deadLines = deadLines;
    }

    public static void setCosts(int[] costs) {
        Shedule.costs = costs;
    }

    public static void setUsed(boolean[] used) {
        Shedule.used = used;
    }

    public static void main(String[] args) {
        System.out.println(getSumCosts());
    }
}


