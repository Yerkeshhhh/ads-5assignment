import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.NodeEntry<K, V>> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null)
            return new Node(key, val);

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        return (node == null) ? null : node.val;
    }

    private Node get(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node successor = min(node.right);
                node.key = successor.key;
                node.val = successor.val;
                node.right = deleteMin(node.right);
            }
        }

        return node;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterator<NodeEntry<K, V>> iterator() {
        List<NodeEntry<K, V>> entries = new ArrayList<>();
        inorderTraversal(root, entries);
        return entries.iterator();
    }

    private void inorderTraversal(Node node, List<NodeEntry<K, V>> entries) {
        if (node != null) {
            inorderTraversal(node.left, entries);
            entries.add(new NodeEntry<>(node.key, node.val));
            inorderTraversal(node.right, entries);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    public static class NodeEntry<K, V> {
        public K key;
        public V value;

        public NodeEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight=height(node.left);
        int rightHeight=height(node.right);

        return Math.max(leftHeight, rightHeight)+1;
    }
}

