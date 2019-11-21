package algebraic;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1,5,6,8,9,5,1};
        for (int size = arr.length - 1; size > 0; size--) {
            sort(arr, size);
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void sort(int[] arr, int size) {

        for (int j = size; j > 0; j--) {
            if (arr[j] > arr[0]) {
                swap(arr, j, 0);
            }
        }
        swap(arr, 0, size);
    }

    private static void swap(int[] arr, int elem, int root) {
        int tmp = arr[root];;
        arr[root] = arr[elem];
        arr[elem] = tmp;
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
        double result = Functions.enumerate(10000);
        long duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Через перебор делителей.");
        start = System.currentTimeMillis();
        result = Functions.enumerate_opt(1000000);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Оптимизаций с использованием массива");
        start = System.currentTimeMillis();
        result = Functions.sieve_of_eratosthenes(1000000);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Решето Эратосфена со сложностью O(n log log n)");
    }

    private static void test_fib() {
        long start = System.currentTimeMillis();
        double result = Functions.fib_rec(25);
        long duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Через рекурсию");
        start = System.currentTimeMillis();
        result = Functions.fib_iter(1000000000);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "Через итерацию");
        start = System.currentTimeMillis();
        result = Functions.fib_golden_ratio(1000000000);
        duration = System.currentTimeMillis() - start;
        System.out.println(result + " " + duration + " ms " + "По формуле золотого сечения");
    }
}
