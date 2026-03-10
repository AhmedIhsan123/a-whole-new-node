import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);

    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    // root.children = new ArrayList<>();
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
    // preorder(root);

    // Testing max method
    // System.out.println(max(root));

    Map<Integer, List<Integer>> tree = new HashMap<>();
    tree.put(33, List.of(24, 61, 12));
    tree.put(17, List.of(5, 99));
    tree.put(58, List.of(73));
    tree.put(24, List.of(83, 6));
    tree.put(88, List.of(17, 58, 33));
    tree.put(5, new ArrayList<>());
    tree.put(99, new ArrayList<>());
    tree.put(73, new ArrayList<>());
    tree.put(83, new ArrayList<>());
    tree.put(6, new ArrayList<>());
    tree.put(61, new ArrayList<>());
    tree.put(12, new ArrayList<>());

    System.out.println(tree);
    preorderMap(tree, 88);
    // System.out.println(tree.get(17));
  }

  /**
   * Pre-order traversal of a tree represented as an adjacency list. Visits the current node before its children.
   * Time complexity: O(n) where n is the number of nodes in the tree.
   * Space complexity: O(h) where h is the height of the tree (due to recursion stack).
   * @param tree
   * @param current
   */
  public static void preorderMap(Map<Integer, List<Integer>> tree, Integer current) {
    if (!tree.containsKey(current)) return;
    System.out.print(current + " ");
    if (tree.get(current).isEmpty()) return;
    for (Integer x : tree.get(current)) {
      preorderMap(tree, x);
    }
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
    // if (node.children == null) return;
    for (int i = 0; i < node.children.size(); i++) {
      preorder(node.children.get(i));
    }
  }

  /**
   * Find the maximum value in a tree of integers. This method assumes that the tree is not empty.
   * Time complexity: O(n) where n is the number of nodes in the tree.
   * Space complexity: O(h) where h is the height of the tree (due to recursion stack).
   * 
   * @param node the root node of the tree to traverse
   * @return the maximum value in the tree
   */
  public static int max(Node<Integer> node) {
    if (node == null) return Integer.MIN_VALUE;
    int maxValue = node.value;
    for (Node<Integer> e : node.children) {
      maxValue = Math.max(maxValue, max(e));
    }
    return maxValue;
  }
}
