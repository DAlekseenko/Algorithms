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
    public T remove(int index) {
        return removeResize(index);
    }

    @Override
    public void add(Object item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    public void add(Object item, int index) {
        addResize(index, item);
    }


    private void resize() {
        Object[] newArray = new Object[size() + 1];

        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    private void addResize(int index, Object item) {
        Object[] newArray = new Object[size() + 1];

        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        System.arraycopy(array, index, newArray, index + 1, size() - index);

        array = newArray;
    }

    private T removeResize(int index) {

        T element = get(index);

        Object[] newArray = new Object[size() - 1];

        if (index == 0) {
            System.arraycopy(array, 1, newArray, 0, size() - 1);
        } else {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size() - index - 1);
        }

        array = newArray;

        return element;
    }
}
