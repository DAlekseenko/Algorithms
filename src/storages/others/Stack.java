package storages.others;

public class Stack<T> {

    private Node<T> head;

    public Stack() {
        head = null;
    }

    public void push(T item) {
        head = new Node<T>(item, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = head.getItem();
        Node<T> getPrev = head.getNext();
        head = getPrev;
        return item;
    }
}

