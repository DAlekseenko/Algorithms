package sorts;

class ShellSorts {
    static int[] first(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int outer = gap; outer < arr.length; outer++) {
                int temp = arr[outer];
                int inner = outer;
                while (inner >= gap && arr[inner - gap] > temp) {
                    arr[inner] = arr[inner - gap];
                    inner = inner - gap;
                }
                arr[inner] = temp;
            }
        }
        return arr;
    }

    static int[] second(int[] arr) {

        int gap = 1;
        while (gap <= arr.length / 3)
            gap = gap * 3 + 1;

        while (gap > 0) {
            for (int outer = gap; outer < arr.length; outer++) {
                int temp = arr[outer];
                int inner = outer;
                while (inner > gap - 1 && arr[inner - gap] >= temp) {
                    arr[inner] = arr[inner - gap];
                    inner -= gap;
                }
                arr[inner] = temp;
            }
            gap = (gap - 1) / 3;
        }
        return arr;
    }
     static int[] third(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
            if (gap == 2) {
                gap = 1;
            } else {
                gap *= (5.0 / 11);
            }
        }
         return arr;
     }
}
