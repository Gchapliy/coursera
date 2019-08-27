package sportProgramming.week3;

import java.util.Arrays;

public class CoinsChange {
    private int[] d;
    private int[] p;
    private int[] a = {1, 6, 7, 10, 22, 23, 25, 36, 37, 59, 60, 61, 79, 80, 101, 139, 289, 355, 357, 429};
    private int sum;

    public CoinsChange(int sum) {
        this.sum = sum;
        this.d = new int[sum + 1];
        this.p = new int[sum + 1];
    }

    public void calculateNumberOfCoins(){

        for (int i = 1; i <= sum; i++) {
            d[i] = sum + 1;
            for (int j = 0; j < a.length; j++) {
                if(i - a[j] >= 0 && d[i - a[j]] + 1 < d[i]){
                    d[i] = d[i - a[j]] + 1;
                    p[i] = a[j];
                }
            }
        }
        System.out.println(d[sum]);
        recout(sum);
    }

    private void recout(int i){
        if(i == 0)
            return;
        recout(i - p[i]);
        if(i - p[i] > 0)
            System.out.print("+");
        System.out.print(p[i]);
    }

    public static void main(String[] args) {
        CoinsChange coinsChange = new CoinsChange(100000);
        coinsChange.calculateNumberOfCoins();
    }
}
