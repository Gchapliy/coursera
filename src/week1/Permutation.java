package week1;

public class Permutation {
    static int n, counter;
    static char[] s;

    static void out() {
        for (int i = 0; i < s.length; i++) {

            System.out.print(s[i]);
        }
        System.out.println("");
        System.out.println("Counter: " + ++counter);
    }

    static boolean isCorrect(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[')
                bal++;
            else if(i > 0 && ((s.charAt(i) == ']' && s.charAt(i - 1) == '(') || (s.charAt(i) == ')' && s.charAt(i - 1) == '[')))
                return false;
            else bal--;
            if (bal < 0)
                return false;
        }
        return (bal == 0);
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
        /*n = 10;
        s = new char[n * 2];
        rec(0, 0);*/
        System.out.println(isCorrect("()()[[[]()]]([()][][()[]])[]()()"));
        System.out.println(isCorrect("[[]](()()[[[]]][]()()()[()])()]"));
        System.out.println(isCorrect("[]()[](((()]))(()()[][])[]([])[]"));
        System.out.println(isCorrect("[[]][()[)[]([][]]()][]()()(())()"));
        System.out.println(isCorrect("(()[([][]())[()][()][][]])([])()"));
    }
}
