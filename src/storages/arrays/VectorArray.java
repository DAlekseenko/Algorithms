package storages.arrays;

import storages.arrays.IArray;

public class VectorArray<T> extends CommonArray<T> {

   private int vector;
   private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray(){
        this(100);
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
        Object[] newArray = new Object[size + vector];

        System.arraycopy(this.array, 0, newArray, 0, this.size);
        array = newArray;
    }



    @Override
    public void add(T item, int index) {

    }

    @Override
    public T remove(int index) {
        return null;
    }
}
