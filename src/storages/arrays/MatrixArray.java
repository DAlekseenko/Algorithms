package storages.arrays;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    @Override
    public int size() {
        return size;
    }

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector) {
            array.add(new VectorArray<>(vector));
        }
        array.get(size / vector).add(item);
        size++;
    }

    @Override
    public T get(int index) {
        return array
                .get(index / vector)
                .get(index % vector);
    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public T remove(int index) {
        return null;
    }
}
