public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "Audi");
        tree.put(2, "Volvo");
        tree.put(3, "Mercedes-Benz");
        tree.put(4, "Porsche");
        System.out.println("The height of BST before deleting is "+tree.height());
        System.out.println(tree.get(4));
        tree.delete(4);

        for (BST.NodeEntry<Integer, String> entry : tree) {
            System.out.println("Key is " + entry.key + " and it is " + entry.value);
        }
        System.out.println("The height of BST after deleting is "+tree.height());
        System.out.println("The size of BST is "+tree.size());
    }
}
