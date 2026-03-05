import java.util.ArrayList;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);

    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children = new ArrayList<>();
    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children = new ArrayList<>();
    child1.children.add(child1_1);
    child1.children.add(child1_2);


    Node<Integer> child2_1 = new Node<>(73);
    child2.children = new ArrayList<>();
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children = new ArrayList<>();
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);


    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children = new ArrayList<>();
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);

    // Testing pre-order traversals
    preorder(root);
  }

  /**
   * Pre-order traversal of a tree. Visits the current node before its children.
   * Time complexity: O(n) where n is the number of nodes in the tree.
   * Space complexity: O(h) where h is the height of the tree (due to recursion stack).
   * 
   * @param node the root node of the tree to traverse
   */
  public static void preorder(Node<?> node) {
    if (node == null) return;
    System.out.print(node.value + " ");
    if (node.children == null) return;
    for (int i = 0; i < node.children.size(); i++) {
      preorder(node.children.get(i));
    }
  }
}
