package sorts;

import java.util.Random;

public class Test {
    public static void main(String[] args) {

        testShellSort();
    }

    static void testShellSort() {
        Random random = new Random();

        int[] arr1 = new int[50000000];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(50000000);
        }

        long start = System.currentTimeMillis();
        int[] result = Sorts.shellSort3(arr1);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms " + "Случайный массив");

        int[] arr2 = new int[50000000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }

        for (int i = 5; i != 0; i--) {
            int randomIndexToSwap = random.nextInt(arr2.length);
            int temp = arr2[randomIndexToSwap];
            arr2[randomIndexToSwap] = arr2[i];
            arr2[i] = temp;
        }

        start = System.currentTimeMillis();
        result = Sorts.shellSort3(arr2);
        duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms " + "массив c 5 перемешаными элементами");

        int[] arr3 = new int[50000000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = i;
        }

        for (int i = arr3.length / 100 * 10; i != 0; i--) {
            int randomIndexToSwap = random.nextInt(arr3.length);
            int temp = arr3[randomIndexToSwap];
            arr3[randomIndexToSwap] = arr3[i];
            arr3[i] = temp;
        }

        start = System.currentTimeMillis();
        result = Sorts.shellSort3(arr3);
        duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms " + "массив c 10% перемешаных элементов");

    }
}
