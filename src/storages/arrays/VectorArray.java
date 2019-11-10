package storages.arrays;

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
        if (size() == array.length) {
            array = resize(array, size() + vector);
        }
        addReIndexArray(index, item);
    }
}
