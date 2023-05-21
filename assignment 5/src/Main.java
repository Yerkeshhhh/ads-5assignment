public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "One");
        tree.put(2, "Two");
        tree.put(3, "Three");

        for (BST.NodeEntry<Integer, String> entry : tree) {
            System.out.println("Key is " + entry.key + " and value is " + entry.value);
        }
    }
}