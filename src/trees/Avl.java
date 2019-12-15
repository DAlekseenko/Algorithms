package trees;

public class Avl<Key extends Comparable<Key>, Value> extends AbstractTree<Key, Value> {

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balance(Node node) {
        return height(node.left) - height(node.right);
    }

    private int calcHeight(Node node) {
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    @Override
    protected Node add(Node node, Key key, Value value, Node father) {
        if (node == null) {
            return new Node(key, value, father);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = add(node.right, key, value, node);
            node.height = calcHeight(node);
        } else if (compareResult < 0) {
            node.left = add(node.left, key, value, node);
            node.height = calcHeight(node);
        } else {
            node.value = value;
        }
        node.balance = balance(node);
        if (node.balance == -2) {
            node = bigLeftRotation(node);
        } else if (node.balance == 2) {
            node = bigRightRotation(node);
        }
        return node;
    }

    Node smallRightRotation(Node node) {
        Node tempNode = node.left;
        tempNode.father = node.father;
        node.left = tempNode.right;
        if (node.left != null)
            node.left.father = node;
        node.height = calcHeight(node);
        node.father = tempNode;
        node.balance = balance(node);
        tempNode.right = node;
        node = tempNode;
        node.balance = balance(node);
        node.height = calcHeight(node);
        return node;
    }

    Node smallLeftRotation(Node node) {
        Node tempNode = node.right;
        tempNode.father = node.father;
        node.right = tempNode.left;
        if (node.right != null)
            node.right.father = node;
        node.height = calcHeight(node);
        node.father = tempNode;
        node.balance = balance(node);
        tempNode.left = node;
        node = tempNode;
        node.balance = balance(node);
        node.height = calcHeight(node);
        return node;
    }

    private Node bigLeftRotation(Node node) {
        if (node.right.right == null && node.right.left != null) {
            node.right = bigRightRotation(node.right);
            node = bigLeftRotation(node);
        } else if (node.right.left == null || node.right.left.height <= node.right.right.height) {
            node = smallLeftRotation(node);
        } else {
            node.right = bigRightRotation(node.right);
            node = bigLeftRotation(node);
        }
        return node;
    }

    private Node bigRightRotation(Node node) {
        if (node.left.right != null && node.left.left == null) {
            node.left = bigLeftRotation(node.left);
            node = bigRightRotation(node);
        } else if (node.left.right == null || node.left.right.height <= node.left.left.height) {
            node = smallRightRotation(node);
        } else {
            node.left = bigLeftRotation(node.left);
            node = bigRightRotation(node);
        }
        return node;
    }

    @Override
    protected Node delete(Node node, Key key) {
        if (node == null) return null;
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
        if (node != null) {
            node.height = calcHeight(node);
            node.balance = balance(node);
            if (node.balance == -2) {
                node = bigLeftRotation(node);
            } else if (node.balance == 2) {
                node = bigRightRotation(node);
            }
        }
        return node;
    }
}
