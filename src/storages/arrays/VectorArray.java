package storages.arrays;

import storages.arrays.IArray;

public class VectorArray<T> extends CommonArray<T> {

    private int vector;

    VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(100);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length) {
            array = resize(array, size() + vector);
        }
        array[size] = item;
        size++;
    }

    @Override
    public void add(int index, T item) {

        if (index > array.length) {
            Object[] newArray = new Object[index];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            array = newArray;
        }

        if(size() == array.length){
            array = resize(array, size() + vector);
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
