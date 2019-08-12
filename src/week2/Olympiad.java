package week2;

public class Olympiad {
    private static int allTime = 50000;
    private static int[] tasksTime = {30, 40, 20};

    public static void setTasksTime(int[] tasksTime) {
        Olympiad.tasksTime = tasksTime;
    }
    
    public static void sortTasksByTime(){
        for (int i = 0; i < tasksTime.length - 1; i++) {
            for (int j = i + 1; j < tasksTime.length; j++) {
                if(tasksTime[j] < tasksTime[i]){
                    //swap tasks
                    tasksTime[i] = tasksTime[i] + tasksTime[j];
                    tasksTime[j] = tasksTime[i] - tasksTime[j];
                    tasksTime[i] = tasksTime[i] - tasksTime[j];
                }
            }
        }
    }

    public static void findAndShowMaxSolvedTasksAndMinPenalty(){
        int currentTime = 0;
        int solvedTasks = 0;
        int penaltiesTime = 0;

        for (int i = 0; i < tasksTime.length; i++) {
            if(currentTime + tasksTime[i] > allTime){
               continue;
            } else {
                currentTime += tasksTime[i];
                penaltiesTime += currentTime;
                solvedTasks++;
            }
        }

        System.out.println(solvedTasks + " " + penaltiesTime);
    }

    public static void main(String[] args) {
        sortTasksByTime();
        findAndShowMaxSolvedTasksAndMinPenalty();
    }
}
