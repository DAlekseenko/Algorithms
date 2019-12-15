package trees;

public interface ITree <Key extends Comparable<Key>, Value> {

    void insert(Key key, Value value);

    Value search(Key key);

    void remove(Key key);

    void print();
}
