package storages.others;

import storages.arrays.IArray;
import storages.arrays.SingleArray;

public class PriorityQueue<T> {

    private IArray<Queue<T>> array;

    public PriorityQueue() {
        array = new SingleArray<>();
    }

    public void enqueue(int priority, T item) {
        if (array.size() < priority) {
            array.add(new Queue<T>(), priority);
        }
        if(array.get(priority) == null){
            array.add(new Queue<T>(), priority);
        }
        array.get(priority).enqueue(item);
    }

    public T dequeue() {
        int size = array.size();
        for (int i = 0; i < size; i++) {
            if(array.get(i) != null) {
                T node = array.get(i).dequeue();
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }
}
