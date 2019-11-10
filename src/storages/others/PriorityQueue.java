package storages.others;

import storages.arrays.IArray;
import storages.arrays.SingleArray;

public class PriorityQueue<T> {

    private IArray<Queue<T>> array;

    public PriorityQueue(int priorities) {
        array = new SingleArray<>();
        for (int i = 0; i <= priorities; i++) {
            array.add(0,new Queue<T>());
        }
    }

    public void enqueue(int priority, T item) {
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
