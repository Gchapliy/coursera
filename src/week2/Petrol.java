package week2;

public class Petrol {
   /* private static int fullTankDistance = 4;
    private static int distanceBetweenCities = 10;
    private static int[] distancesToGasStations = {3, 4, 6};*/
    private static int fullTankDistance = 25;
    private static int distanceBetweenCities = 100;
    private static int[] distancesToGasStations = {13, 16, 21, 35, 38, 61, 67, 70, 77, 81};

    public static void setFullTankDistance(int fullTankDistance) {
        Petrol.fullTankDistance = fullTankDistance;
    }

    public static void setDistanceBetweenCities(int distanceBetweenCities) {
        Petrol.distanceBetweenCities = distanceBetweenCities;
    }

    public static void setDistancesToGasStations(int[] distancesToGasStations) {
        Petrol.distancesToGasStations = distancesToGasStations;
    }

    public static int calculateGasStationsCount(boolean isGreedyAlgorithm) {
        int gasStationsCount = 0;
        int currentPetrol = fullTankDistance;
        int travelledDistance = 0;

        for (int i = 0; i < distancesToGasStations.length; i++) {
            currentPetrol -= (distancesToGasStations[i] - travelledDistance);
            distanceBetweenCities -= (distancesToGasStations[i] - travelledDistance);
            travelledDistance += (distancesToGasStations[i] - travelledDistance);

            if (currentPetrol - distanceBetweenCities < 0) {
                if (!isGreedyAlgorithm)
                    if (i < distancesToGasStations.length - 1) {
                        if (currentPetrol - (distancesToGasStations[i + 1] - distancesToGasStations[i]) < 0) {
                            currentPetrol = fullTankDistance;
                            gasStationsCount++;
                        }
                    } else {
                        currentPetrol = fullTankDistance;
                        gasStationsCount++;
                    }

                if (isGreedyAlgorithm) {
                    currentPetrol = fullTankDistance;
                    gasStationsCount++;
                }
            }
        }

        return gasStationsCount;
    }

    public static void main(String[] args) {
        System.out.println(calculateGasStationsCount(false));
    }
}
