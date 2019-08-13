package sportProgramming.week2;

public class Requests {
    private static int[] leftLimit = {1, 3, 5};
    private static int[] rightLimit = {5, 6, 7};

    public static void setLeftLimit(int[] leftLimit) {
        Requests.leftLimit = leftLimit;
    }

    public static void setRightLimit(int[] rightLimit) {
        Requests.rightLimit = rightLimit;
    }

    private static void sortRequestsByRightLimit(){

        for (int i = 0; i < rightLimit.length - 1; i++) {
            for (int j = i + 1; j < rightLimit.length; j++) {
                if(rightLimit[j] < rightLimit[i]){
                    //right limit swap
                    rightLimit[i] = rightLimit[i] + rightLimit[j];
                    rightLimit[j] = rightLimit[i] - rightLimit[j];
                    rightLimit[i] = rightLimit[i] - rightLimit[j];
                    
                    //left limit swap
                    leftLimit[i] = leftLimit[i] + leftLimit[j];
                    leftLimit[j] = leftLimit[i] - leftLimit[j];
                    leftLimit[i] = leftLimit[i] - leftLimit[j];
                }
            }
        }
    }

    public static int findMaxRequestsCountToAccess() {
        int countAccessRequests = 1;
        int lastAccessRequest = 0;
        boolean[] used = new boolean[leftLimit.length];

        //sort requests by right limit before searching
        sortRequestsByRightLimit();

        for (int i = 1; i < leftLimit.length; i++) {
            if (leftLimit[i] >= rightLimit[lastAccessRequest]) {
                countAccessRequests++;
                lastAccessRequest = i;
            } else {

            }
        }

        return countAccessRequests;
    }

    public static int findMaxClassRoomsCountToAccess() {
        int countAccessClassRooms = 1;
        int lastAccessRequest = 0;

        //sort requests by right limit before searching
        sortRequestsByRightLimit();

        for (int i = 1; i < leftLimit.length; i++) {
            if (leftLimit[i] >= rightLimit[lastAccessRequest]) {
                countAccessClassRooms++;
                lastAccessRequest = i;
            } else {
                for (int j = 0; j < i; j++) {
                    if(rightLimit[j] == leftLimit[i]){
                        break;
                    } else if(j == i - 1){
                        countAccessClassRooms++;
                    }
                }
            }
        }

        return countAccessClassRooms;
    }

    public static void main(String[] args) {
        System.out.println(findMaxRequestsCountToAccess());
    }
}
