package week2;

import java.util.Arrays;

public class Requests {
    private static int[] leftLimit = {1, 0, 4, 18, 2, 5, 1, 1, 2, 7};
    private static int[] rightLimit = {7, 14, 9, 19, 4, 6, 7, 11, 15, 16};

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

        //sort requests by right limit before searching
        sortRequestsByRightLimit();

        for (int i = 1; i < leftLimit.length; i++) {
            if (leftLimit[i] >= rightLimit[lastAccessRequest]) {
                countAccessRequests++;
                lastAccessRequest = i;
            }
        }

        return countAccessRequests;
    }

    public static void main(String[] args) {
        System.out.println(findMaxRequestsCountToAccess());
    }
}
