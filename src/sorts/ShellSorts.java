package sorts;

class ShellSorts {

    private int[] array;

    private int variant;

    void setArray(int[] array) {
        this.array = array;
    }

    int[] getArray() {
        return array;
    }

    void setVariant(int variant) {
        this.variant = variant;
    }

    void sort(){

    }

    static int[] classic(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            breaker(arr, gap);
            gap /= 2;
        }
        return arr;
    }

    static int[] second(int[] arr) {
        int gap = 1;
        while (gap <= arr.length / 3)
            gap = gap * 3 + 1;

        while (gap > 0) {
            breaker(arr, gap);
            gap = (gap - 1) / 3;
        }
        return arr;
    }

    private static void breaker(int[] arr, int gap) {
        for (int outer = gap; outer < arr.length; outer++) {
            int temp = arr[outer];
            int inner = outer;
            while (inner > gap - 1 && arr[inner - gap] >= temp) {
                arr[inner] = arr[inner - gap];
                inner -= gap;
            }
            arr[inner] = temp;
        }
    }

    static int[] third(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            breaker(arr, gap);
            if (gap == 2) {
                gap = 1;
            } else {
                gap *= (5.0 / 11);
            }
        }
        return arr;
    }
}
