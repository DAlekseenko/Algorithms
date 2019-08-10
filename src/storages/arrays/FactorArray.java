package storages.arrays;

import storages.arrays.IArray;

public class FactorArray<T> extends CommonArray<T> {

    private int factor;
    private int size;

    public FactorArray() {
        this.factor = 1000;
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
        Object[] newArray = new Object[size + (size * (factor / 100))];

        System.arraycopy(this.array, 0, newArray, 0, this.size);
        array = newArray;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public T remove(int index) {
        return null;
    }
}
