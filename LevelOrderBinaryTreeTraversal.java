import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class LevelOrderBinaryTreeTraversal {

    static Node root;
    private static ArrayList<Integer> levelOrderData;
    private static ArrayList<Integer> levelOrderDataRecursive;
    private static ArrayList<Integer> level2DataRecursive;

    private static ArrayList<List<Integer>> bottomUpLevelOrder;
    private static ArrayList<Integer> levelData;

    private static int treeHeight;

    public static void main(String[] args) {
        LevelOrderBinaryTreeTraversal tree = new LevelOrderBinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(4);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.levelOrderData = new ArrayList<Integer>();
        tree.levelOrder(root, levelOrderData);
        System.out.println("Level Order: " + tree.levelOrderData);

        tree.treeHeight = tree.calculateTreeHeight(root);

        System.out.println("Height of Binary Tree: " + tree.treeHeight);

        tree.levelOrderDataRecursive = new ArrayList<Integer>();

        for(int i=0; i<tree.treeHeight; i++)
            tree.levelOrderRecursive(tree.root, i, tree.levelOrderDataRecursive);

        System.out.println("Level Order Recursive: " + tree.levelOrderDataRecursive);

        tree.level2DataRecursive = new ArrayList<Integer>();
        tree.levelOrderRecursive(tree.root, 0, tree.level2DataRecursive);
        System.out.println("Level 2 Order Recursive: " + tree.level2DataRecursive);

        tree.bottomUpLevelOrder = new ArrayList<List<Integer>>();
        tree.levelData = new ArrayList<Integer>();

        for(int i=treeHeight-1; i>=0; i--) {
            tree.levelData.clear();
            tree.levelOrderRecursive(root, i, tree.levelData);
            System.out.println(tree.levelData);
            tree.bottomUpLevelOrder.add(tree.levelData);
            System.out.println(tree.bottomUpLevelOrder);
        }
    }

    private void levelOrder(Node node, ArrayList<Integer> levelOrderData) {
        if(node == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node current = q.peek();
            levelOrderData.add(current.data);
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
            q.remove();
        }
    }

    private int calculateTreeHeight(Node node) {
        if(node == null)
            return 0;

        int leftHeight = calculateTreeHeight(node.left);
        int rightHeight = calculateTreeHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void levelOrderRecursive(Node node, int level, ArrayList<Integer> levelOrderDataRecursive) {
        if(node == null)
            return;

        if(level == 0)
            levelOrderDataRecursive.add(node.data);

        levelOrderRecursive(node.left, level-1, levelOrderDataRecursive);
        levelOrderRecursive(node.right, level-1, levelOrderDataRecursive);
    }
}
