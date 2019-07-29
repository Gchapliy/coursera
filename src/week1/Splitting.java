package week1;

import java.util.Arrays;

public class Splitting {
    static int sum, n, counter;
    static int[]a;

    static void out(int idx){
        for (int i = 0; i < idx; i++) {
            System.out.print(a[i] + " ");
        }
        //System.out.println(Arrays.toString(a));
        System.out.println("\nCounter: " + ++counter);
    }

    static void rec(int idx, int sum, int last){
        if(sum == n){
            out(idx);
            return;
        }

        for (int i = last; i <= n - sum ; i++) {
            a[idx] = i;
            rec(idx + 1, sum + i, i);
        }
    }

    public static void main(String[] args) {
        n = 35;
        a = new int[n];
        sum = 0;
        rec(0, 0, 1);
    }
}
