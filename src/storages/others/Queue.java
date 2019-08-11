package storages.others;

public class Queue<T> {

    private Node<T> head, tail;

    public Queue() {
        head = tail = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<T>(item);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = head.getItem();
        head = head.getNext();

        return item;
    }
}
