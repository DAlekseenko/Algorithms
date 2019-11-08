package storages.arrays;

import storages.arrays.IArray;

public class SingleArray<T> extends CommonArray<T> {

    public SingleArray() {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(Object item) {
        array = resize(array,  1);
        array[size() - 1] = item;
    }

    @Override
    public void add(int index, Object item) {

        Object[] newArray = resize(array, 1);

        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        System.arraycopy(array, index, newArray, index + 1, size() - index);

        array = newArray;
    }
}
