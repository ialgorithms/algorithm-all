package net.ijiangtao.tech.algorithms.algorithmall.datastructure.binarytree.bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node leftNode, rightNode;
        private int nodeNumber;
        public Node(Key key, Value value, int nodeNumber) {
            this.key = key;
            this.value = value;
            this.nodeNumber = nodeNumber;
        }
    }

    /**
     * 根节点
     */
    private Node rootNode;

    private int size(Node node) {
        if (null == node) {
            return 0;
        } else {
            return node.nodeNumber;
        }
    }

    /**
     * @return 根节点以及根节点下的子节点总数
     */
    public int size() {
        return size(rootNode);
    }

    private Value get(Node node, Key key) {
        if (null == node) {
            return null;
        }

        int compareResult = key.compareTo(node.key);

        if (compareResult < 0) {
            return get(node.leftNode, key);
        } else if (compareResult > 0) {
            return get(node.rightNode, key);
        } else {
            return node.value;
        }
    }

    public Value get(Key key) {
        return get(rootNode, key);
    }

    public void put(Key key, Value value) {
        rootNode = put(rootNode, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int compareResult = key.compareTo(node.key);

        if (compareResult < 0) {
            return node.leftNode = put(node.leftNode, key, value);
        } else if (compareResult > 0) {
            return node.rightNode = put(node.rightNode, key, value);
        } else {
            node.value = value;
        }

        node.nodeNumber = size(node.leftNode) + size(node.rightNode) + 1;

        return node;
    }

    public Node min() {
        return min(rootNode);
    }

    private Node min(Node node) {
        if (null == node.leftNode) {
            return node;
        }
        return min(node.leftNode);
    }

    public Node max() {
        return max(rootNode);
    }

    private Node max(Node node) {
        if (null == node.rightNode) {
            return node;
        }
        return min(node.rightNode);
    }
}
