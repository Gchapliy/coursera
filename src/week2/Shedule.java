package week2;

public class Shedule {
    private static int[] deadLines = {2, 2, 1, 7, 5, 5, 4, 7, 7, 5};
    private static int[] costs = {92, 80, 66, 55, 55, 38, 35, 19, 16, 2};

    public static long getSumCosts(){
        long sum = 0;

        // sort shedule by cost before
        sortSheduleByCosts();

        boolean[] used = new boolean[deadLines.length + 1];

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

    private static void sortSheduleByCosts(){

        for (int i = 0; i < costs.length - 1; i++) {
            for (int j = i + 1; j < costs.length; j++) {
                if(costs[j] < costs[i]){
                    //right limit swap
                    costs[i] = costs[i] + costs[j];
                    costs[j] = costs[i] - costs[j];
                    costs[i] = costs[i] - costs[j];

                    //left limit swap
                    deadLines[i] = deadLines[i] + deadLines[j];
                    deadLines[j] = deadLines[i] - deadLines[j];
                    deadLines[i] = deadLines[i] - deadLines[j];
                }
            }
        }
    }

    public static void setDeadLines(int[] deadLines) {
        Shedule.deadLines = deadLines;
    }

    public static void setCosts(int[] costs) {
        Shedule.costs = costs;
    }

    public static void main(String[] args) {
        System.out.println(getSumCosts());
    }
}


