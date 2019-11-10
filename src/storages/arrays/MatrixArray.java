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
        if (size() == array.size() * vector) {
            array.add(new VectorArray<T>(vector));
        }
        array.get(size / vector).add(item);
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (size() == array.size() * vector) {
            array.add(new VectorArray<T>(vector));
        }
        int toPush = index / vector;
        for (int i = array.size() - 1; i > toPush; --i) {
            int elementIndex = array.get(i - 1).size() - 1;
            T element = array.get(i - 1).get(elementIndex);
            array.get(i).add(0, element);
            array.get(i - 1).remove(elementIndex);
        }
        array.get(toPush).add(index % vector, item);
        size++;
    }

    @Override
    public T get(int index) {
        return array
                .get(index / vector)
                .get(index % vector);
    }

    @Override
    public T remove(int index) {
        int toRemoved = index / vector;
        T removed = array.get(toRemoved).remove(index % vector);
        for (int i = toRemoved + 1; i < array.size(); ++i) {
            T element = array.get(i).get(0);
            array.get(i - 1).add(element);
            array.get(i).remove(0);
        }
        if (array.get(array.size() - 1).size() == 0){
            array.remove(array.size() - 1);
        }
        size--;
        return removed;
    }
}
