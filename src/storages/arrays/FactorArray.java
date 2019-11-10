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

    private int getDelta(){
        return  size() * (factor / 100); // size * 1
    }
    @Override
    public void add(T item) {
        if(size() == array.length){
            array = resize(array, getDelta());
        }
        array[size] = item;
        size++;
    }

    @Override
    public void add(int index, T item) {
        if(size() == array.length){
            array = resize(array, getDelta());
        }
        addReIndexArray(index, item);
    }
}
