package sorts;

import storages.arrays.IArray;

class ShellSort {

    private int[] arr;

    void setArr(int[] arr) {
        this.arr = arr;
    }

    int[] getArr() {
        return arr;
    }

    void sort(IArray<Integer> seq){
        for (int i = seq.size() - 1; i >= 0; i--) {
            insert(seq.get(i));
        }
    }

    private void insert(int gap) {
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
}