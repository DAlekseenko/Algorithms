package algebraic;

public class Funcs {


    static private void node() {
        long start = System.currentTimeMillis();
        int a = 1234567890;
        int b = 12;
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;

            } else {
                b = b % a;
            }
        }
        System.out.println(a);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
    }

    static private void squared() {
        long start = System.currentTimeMillis();

        double a = 2;
        long power = 8;
        long j = 1;

        int k = 1;
        double res = a;
        while (k < power) {
            res *= res;
            k *= 2;
        }
        double base = power - k;
        System.out.println(base);
        for (int i = 0; i < base; i++) {
            res *= base;
        }

        System.out.println(res);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
    }

    static private void eratrosfen() {
        long start = System.currentTimeMillis();


//        int c = 0;
//        long p = 100000;
//
//        for (int i = 2)
//            for (int j = 3; j * j <= p; j += 2) {
//                if (p % j == 0) {
//                    c++;
//                }
//
//            }
        //System.out.println(c);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
    }

    static public void fib() {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        System.out.print(n0 + " " + n1 + " ");
        for (int i = 3; i <= 1000; i++) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        System.out.println(n2);
    }
}
