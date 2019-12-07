package sorts;

import storages.arrays.IArray;
import storages.arrays.SingleArray;
import storages.arrays.VectorArray;

public class ShellSequences {
    public IArray<Integer> getShellSequence(int length, int vector) {
        VectorArray<Integer> list = new VectorArray<>(vector);
        int gap = length / 2;
        while (gap > 0) {
            list.add(gap);
            gap /= 2;
        }
        return list;
    }

    public IArray<Integer> getPrattKnuthSequence(int length, int vector) {
        VectorArray<Integer> list = new VectorArray<>(vector);
        int gap = 1;
        while (gap <= length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            list.add(gap);
            gap = (gap - 1) / 3;
        }
        return list;
    }

    public IArray<Integer> getPrattSequence(int length, int vector) {
        VectorArray<Integer> list = new VectorArray<>(vector);
        int index = 0;
        int[] array = new int[100];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[index] = (int) (Math.pow(2, i) * Math.pow(3, j));
                index++;
            }
        }
        new QuickSort(array);

        for (int i = array.length / 2; i >= 0; i--) {
            int gap = array[i];
            if (gap < length) {
                list.add(gap);
            }
        }
        return list;
    }

    public IArray<Integer> getGonnetSequence(int length, int vector) {
        VectorArray<Integer> list = new VectorArray<>(vector);
        int gap = 5 * length / 11;
        while (gap > 0) {
            list.add(gap);
            gap = 5 * gap / 11;
        }
        return list;
    }

    public IArray<String> getSequences() {
        SingleArray<String> arr = new SingleArray<>();
        arr.add("Shell");
        arr.add("PrattKnuth");
        arr.add("Pratt");
        arr.add("Gonnet");
        return arr;
    }
}
