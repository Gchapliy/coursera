package week1;

public class StarsPermutation {
    static int n, counter, stars, cs;
    static char[] s;

    static void out() {
        for (int i = 0; i < s.length; i++) {

            System.out.print(s[i]);
        }
        System.out.println("");
        System.out.println("Counter: " + ++counter);
    }

    static void rec(int idx) {
        if (idx == n) {
            if (cs == stars)
                out();
            return;
        }

        s[idx] = '*';
        cs++;
        rec(idx + 1);

    }

    public static void main(String[] args) {
        n = 5;
        stars = 2;
        s = new char[n];
        rec(0);
    }
}
