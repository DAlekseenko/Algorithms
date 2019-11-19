package algebraic;

public class Test {

    public static void main(String[] args) {
        test_simple_number();
    }

    private static void test_gcd() {
        long start = System.currentTimeMillis();
        long result = Functions.gcd(256256, 512);
        long duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "НОД");
        start = System.currentTimeMillis();
        result = Functions.gcd_bit(256256, 512);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "НОД Bit");
    }

    private static void test_pow() {
        long start = System.currentTimeMillis();
        double result = Functions.exponentiation_iter(2, 1000000011);
        long duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Итеративный (n умножений)");
        start = System.currentTimeMillis();
        result = Functions.exp_pow_multi(2, 1000000011);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Через степень двойки с домножением");
        start = System.currentTimeMillis();
        result = Functions.double_decomposition_pow(2, 1000000011);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Через двоичное разложение показателя степени.");
    }

    private static void test_simple_number() {
        long start = System.currentTimeMillis();
        double result = Functions.enumerate(100000);
        long duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Через перебор делителей.");
        start = System.currentTimeMillis();
        result = Functions.enumerate_opt(100000);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Оптимизаций с использованием массива");
        start = System.currentTimeMillis();
        result = Functions.sieve_of_eratosthenes( 100000);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Решето Эратосфена со сложностью O(n log log n)");
    }

}
