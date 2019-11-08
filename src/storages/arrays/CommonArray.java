package storages.arrays;

public abstract class CommonArray<T> implements IArray<T> {

    int size;

    Object[] array;

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T remove(int index) {
        T element = get(index);

        Object[] newArray = new Object[array.length - 1];

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

    protected Object[] resize(Object[] array, int delta) {
        Object[] newArray = new Object[size() + delta];
        System.arraycopy(array, 0, newArray, 0, size());
        return newArray;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result = String.format("%s %s", result, get(i));
        }
        result += "]";
        return result;
    }
}
