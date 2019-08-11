package week2;

public class BackPack {

    /*private static int maxWeight = 4;
    private static int[] weights = {2, 3};
    private static int[] costs = {10, 12};*/

    private static int maxWeight = 100;
    private static int[] weights = {16, 27, 11, 6, 23, 13, 19, 10, 17, 6};
    private static int[] costs = {48, 81, 66, 60, 69, 130, 95, 30, 85, 30};

    public static void setWeights(int[] weights) {
        BackPack.weights = weights;
    }

    public static void setCosts(int[] costs) {
        BackPack.costs = costs;
    }

    public static int findMaxCost(){
        int maxCost = 0;
        int currentWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if(currentWeight + weights[i] <= maxWeight){
                currentWeight += weights[i];
                maxCost += costs[i];
            } else {
                int onePartCosts = costs[i] / weights[i];

                while (currentWeight != maxWeight){
                    currentWeight++;
                    maxCost += onePartCosts;
                }
            }

        }

        return maxCost;
    }

    public static void main(String[] args) {
        System.out.println(findMaxCost());
    }
}
