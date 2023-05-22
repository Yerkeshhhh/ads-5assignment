public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "One");
        tree.put(2, "Two");
        tree.put(3, "Three");
        tree.put(4, "Four");
        System.out.println("The height of BST before deleting is "+tree.height());
        System.out.println(tree.get(1));
        tree.delete(1);

        for (BST.NodeEntry<Integer, String> entry : tree) {
            System.out.println("Key is " + entry.key + " and value is " + entry.value);
        }
        System.out.println("The height of BST after deleting is "+tree.height());
        System.out.println("The size of BST is "+tree.size());
    }
}
