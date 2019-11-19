package algebraic;

import storages.arrays.IArray;
import storages.arrays.SingleArray;
import storages.arrays.VectorArray;

public class Functions {

    static long gcd(long a, long b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }

    static long gcd_bit(long a, long b) {
        int shift;
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        for (shift = 0; ((a | b) & 1) == 0; ++shift) {
            a >>= 1;
            b >>= 1;
        }
        while ((a & 1) == 0)
            a >>= 1;
        do {
            while ((b & 1) == 0)
                b >>= 1;
            if (a > b) {
                long t = b;
                b = a;
                a = t;
            }
            b = b - a;
        } while (b != 0);
        return a << shift;
    }

    static double exponentiation_iter(double number, long pow) {
        double res = 1;
        for (long i = 0; i < pow; i++) {
            res *= number;
        }
        return res;
    }

    static double exp_pow_multi(double number, long pow) {
        long power = 1;
        double res = number;

        while (power < pow / 2) {
            res *= res;
            power *= 2;
        }

        while (power < pow) {
            res *= number;
            power++;
        }
        return res;
    }

    static double double_decomposition_pow(double number, long pow) {
        double res = 1;

        while (pow > 1) {
            if (pow % 2 == 1) {
                res *= number;
            }
            number *= number;
            pow /= 2;
        }
        if (pow > 0) res *= number;
        return res;
    }

    static int enumerate(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            int div = 1;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    div++;
                }
            }
            if (div == 2) {
                count++;
            }
        }
        return count;
    }

    static int enumerate_opt(int n) {
        int count = 1;
        IArray<Integer> simpleNumbers = new SingleArray<>();
        simpleNumbers.add(2);
        for (int i = 3; i <= n; i++) {
            int div = 0;
            for (int j = 0; simpleNumbers.get(j) * simpleNumbers.get(j) <= i; j++) {
                if (i % simpleNumbers.get(j) == 0) {
                    div++;
                    break;
                }
            }
            if (div == 0) {
                simpleNumbers.add(i);
                count++;
            }
        }
        return count;
    }

    static int sieve_of_eratosthenes(int n) {
        boolean[] simpleNumbers = new boolean[n + 1];
        int i = 2;

        while (i <= n) {
            simpleNumbers[i] = true;
            i++;
        }
        for (int j = 2; j < simpleNumbers.length; j++) {
            if (simpleNumbers[j]) {
                for (int k = j; k * j < simpleNumbers.length; k++) {
                    simpleNumbers[k * j] = false;
                }
            }
        }
        i = 2;
        int count = 0;
        while (i <= n) {
            if (simpleNumbers[i]) {
                count++;
            }
            i++;
        }
        return count;
    }

    static public void fib() {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        System.out.print(n0 + " " + n1 + " ");
        for (int i = 3; i <= 13; i++) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        System.out.println(n2);
    }
}
