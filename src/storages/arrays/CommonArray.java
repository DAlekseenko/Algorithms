package storages.arrays;

public abstract class CommonArray<T> implements IArray<T> {

    int size;

    Object[] array;

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    public T remove(int index) {
        T element = get(index);

        Object[] newArray = new Object[array.length - 1];

        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);

        size--;
        array = newArray;
        return element;
    }

    Object[] resize(Object[] array, int delta) {
        Object[] newArray = new Object[size() + delta];
        System.arraycopy(array, 0, newArray, 0, size());
        return newArray;
    }
}
