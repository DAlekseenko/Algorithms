package sorts;

class HeapSort {

    private int[] array;

    void setArray(int[] array) {
        this.array = array;
    }

    int[] getArray() {
        return array;
    }

    void sort() {
        for(int node = array.length / 2 - 1; node >= 0; node--){
            down(array.length, node);
        }
        down(array.length, 0);
        for (int size = array.length - 1; size >= 0; size--) {
            swap(0, size);
            down(size, 0);
        }
    }

    private void down(int size, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int newRoot = root;
        if (left < size && array[left] > array[newRoot]) {
            newRoot = left;
        }
        if (right < size && array[right] > array[newRoot]) {
            newRoot = right;
        }
        if (newRoot == root) {
            return;
        }
        swap(root, newRoot);
        down(size, newRoot);
    }

    private void swap(int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
