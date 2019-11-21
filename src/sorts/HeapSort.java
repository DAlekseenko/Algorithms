package sorts;

class HeapSort {

    private int[] array;

    HeapSort(int[] array) {
        this.array = array;
        sort();
    }

    int[] getArray() {
        return array;
    }

    private void sort() {
        maxToRoot(array.length, 0);
        for (int size = array.length - 1; size >= 0; size--) {
            swap(0, size);
            maxToRoot(size, 0);
        }
    }

    private void maxToRoot(int size, int root) {
        for (int j = root + 1; j < size; j++) {
            if (array[j] > array[root]) {
                swap(j, root);
            }
        }
    }

    private void swap(int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
