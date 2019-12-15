package trees;


public class BinaryTree<Key extends Comparable<Key>, Value> extends AbstractTree<Key, Value> {

    protected Node add(Node node, Key key, Value value, Node father) {
        if (node == null) {
            return new Node(key, value, father);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = add(node.right, key, value, node);
        } else if (compareResult < 0) {
            node.left = add(node.left, key, value, node);
        } else {
            node.value = value;
        }
        return node;
    }
    protected Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = delete(node.right, key);
        } else if (compareResult < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.right == null && node.left == null) {
                node = null;
            } else if (node.right == null) {
                node.left.father = node.father;
                node = node.left;
            } else if (node.left == null) {
                node.right.father = node.father;
                node = node.right;
            } else {
                if (node.right.left == null) {
                    node.right.left = node.left;
                    node.right.father = node.father;
                    node.left.father = node.right;
                    node = node.right;
                } else {
                    Node res = min(node.right);
                    node.key = res.key;
                    node.value = res.value;
                    delete(node.right, node.key);
                }
            }
        }
        return node;
    }
}
