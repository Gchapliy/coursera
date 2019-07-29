package week1;

import java.util.concurrent.TimeUnit;

public class Sequences {
    public static int n,m, counter;
    public static int[] arr;

    public static void out(){
        for (int i = 0; i < n; i++) {

            System.out.print(arr[i] + " ");
        }
        System.out.println("\nCounter: " + ++counter);
    }

    public static void rec(int idx){
        if(idx == n)
        {
            out();
            return;
        }

        for (int i = 1; i <= m; i++) {
            arr[idx] = i;
            rec(idx + 1);
        }
    }

    public static void main(String[] args) {
        n = 7;
        m = 7;
        arr = new int[n];
        rec(0);
    }
}
