package storages.others;

class Node<T> {

    private T item;
    private Node<T> next;

    Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }


    Node(T item) {
        this(item, null);
    }

    T getItem() {
        return item;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }
}
