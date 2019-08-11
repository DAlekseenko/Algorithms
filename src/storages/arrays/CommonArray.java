package storages.arrays;

public abstract class CommonArray<T> implements IArray<T> {

    protected Object[] array;

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }
}
