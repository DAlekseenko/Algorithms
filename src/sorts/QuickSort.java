package sorts;

public class QuickSort {

    private int[] array;

    QuickSort(int[] array) {
        this.array = array;
        sort(35);
    }

    int[] getArray() {
        return array;
    }

    private int sort(int pivot) {

        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (i <= pivot) {
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

    private void func(int [] array, int left, int right){

    }
}
