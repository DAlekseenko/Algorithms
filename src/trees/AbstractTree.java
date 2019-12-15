package trees;

public abstract class AbstractTree<Key extends Comparable<Key>, Value> implements ITree<Key, Value> {

    public class Node {
        protected int height;
        protected int balance;
        Key key;
        Value value;
        protected Node left, right, father;

        public Node(Key key, Value value, Node father) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
            this.father = father;
            this.height = 1;
            this.balance = 0;
        }
    }

    protected Node root;

    protected Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    protected Node max(Node node) {
        if (node.right == null) return node;
        return min(node.right);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int compareResult = key.compareTo(node.key);
        if (compareResult == 0) {
            return node.value;
        } else if (compareResult > 0) {
            return get(node.right, key);
        }
        return get(node.left, key);
    }

    public Value search(Key key) {
        return get(root, key);
    }

    abstract protected Node add(Node node, Key key, Value value, Node father);

    abstract protected Node delete(Node node, Key key);

    public void insert(Key key, Value value) {
        root = add(root, key, value, null);
    }

    public void remove(Key key) {
        root = delete(root, key);
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node node, int level) {
        if (node != null) {
            print(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key + "->" + node.value + " h=" + node.height + " balance=" + node.balance);

            print(node.left, level + 1);
        }
    }
}
