package sorts;

public class MergeSort {

    private int[] array;

    MergeSort(int[] array) {
        this.array = array;
        sort(0, array.length - 1);
    }


    void setArray(int[] array) {
        this.array = array;
    }

    int[] getArray() {
        return array;
    }

    void sort(int left, int right){
        if(left >= right) {
            return;
        }
        int center = left + (right - left) / 2;
        sort(left, center);
        sort(center + 1, right);
        merge(left, center, right);
    }
    void merge(int left, int center, int right) {
        int[] arr = new int[right - left + 1];
        int a = left;
        int b = center + 1;
        int i = 0;
        while (a <= center && b <= right){
            if(array[a] < array[b]){
                arr[i] = array[a];
                a++;
            } else {
                arr[i] = array[b];
                b++;
            }
            i++;
        }
        while (a <= center){
            arr[i] = array[a];
            i++;
            a++;
        }
        while (b <= right){
            arr[i] = array[b];
            i++;
            b++;
        }

        if (right + 1 - left >= 0) {
            System.arraycopy(arr, 0, array, left, right + 1 - left);
        }
    }
}
