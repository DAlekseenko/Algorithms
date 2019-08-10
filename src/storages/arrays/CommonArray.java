package storages.arrays;

public abstract class CommonArray<T> implements IArray<T> {

    protected Object[] array;

    @Override
    public T get(int index) {
        return (T) array[index];
    }
}
