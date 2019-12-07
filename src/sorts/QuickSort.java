package sorts;

public class QuickSort {

    private int[] array;

    QuickSort(int[] array) {
        this.array = array;
        sort(0, array.length - 1);
    }

    int[] getArray() {
        return array;
    }

    private void sort(int left, int right) {
        if (left >= right) return;

        int center = partition(left, right);
        sort(left, center -1);
        sort(center + 1, right);
    }

    private int partition(int left, int right) {
        int index = left - 1;
        int pivot = array[right];

        for (int i = left; i <= right; i++) {
            if (array[i] <= pivot) {
                index++;
                swap(index, i);
            }
        }
        return index;
    }

    private void swap(int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
