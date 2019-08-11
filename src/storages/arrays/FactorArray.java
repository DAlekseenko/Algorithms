package storages.arrays;

import storages.arrays.IArray;

public class FactorArray<T> extends CommonArray<T> {

    private int factor;
    private int size;

    public FactorArray() {
        this.factor = 100;
        array = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if(size() == array.length){
            resize();
        }
        array[size] = item;
        size++;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + (array.length * (factor / 100))];

        System.arraycopy(this.array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public void add(T item, int index) {

        while (index > array.length) {
            Object[] newArray = new Object[array.length + (array.length * (factor / 100))];
            System.arraycopy(this.array, 0, newArray, 0, array.length);
            array = newArray;
        }

        if(size() == array.length){
            resize();
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

    @Override
    public T remove(int index) {
        T element = get(index);

        Object[] newArray = new Object[array.length];

        if (index == 0) {
            System.arraycopy(array, 1, newArray, 0, array.length - 1);
        } else {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        }
        size--;
        array = newArray;

        return element;
    }

}
