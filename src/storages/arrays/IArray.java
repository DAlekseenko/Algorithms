package storages.arrays;


public interface IArray<T> {

    int size();

    void add(T item);

    void add(int index, T item);

    T get(int index);

    T remove(int index);

}
