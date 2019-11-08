package storages.arrays;

import storages.arrays.IArray;

public class FactorArray<T> extends CommonArray<T> {

    private int factor;

    public FactorArray() {
        this.factor = 100;
        array = new Object[this.factor];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if(size() == array.length){
            int delta = size() * (factor / 100); // size * 1
            array = resize(array, delta);
        }
        array[size] = item;
        size++;
    }

    @Override
    public void add(int index, T item) {

        if (index > array.length) {
            Object[] newArray = new Object[index];
            System.arraycopy(this.array, 0, newArray, 0, array.length);
            array = newArray;
        }

        if(index == array.length){
            int delta = size() * (factor / 100);
            array = resize(array, delta);
        }

        Object[] newArray = new Object[array.length];

        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        if (index < size()) {
            System.arraycopy(array, index, newArray, index + 1, array.length - index - 1);
        }
        size++;
        array = newArray;
    }
}
