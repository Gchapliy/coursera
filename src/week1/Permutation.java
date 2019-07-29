package week1;

public class Permutation {
    static int n, counter;
    static char[] s;

    public static void out() {
        for (int i = 0; i < s.length; i++) {

            System.out.print(s[i]);
        }
        System.out.println("");
        System.out.println("Counter: " + ++counter);
    }

    static void rec(int idx, int bal) {
        if (idx == 2 * n) {
            if (bal == 0)
                out();
            return;
        }

        s[idx] = '(';
        rec(idx + 1, bal + 1);
        if (bal == 0)
            return;
        s[idx] = ')';
        rec(idx + 1, bal - 1);
    }

    public static void main(String[] args) {
        n = 3;
        s = new char[n * 2];
        rec(0, 0);
    }
}
