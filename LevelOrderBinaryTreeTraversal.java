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
    private ArrayList<Integer> levelOrderData;

    public static void main(String[] args) {
        LevelOrderBinaryTreeTraversal tree = new LevelOrderBinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.levelOrderData = new ArrayList<Integer>();
        tree.levelOrder(root, levelOrderData);
        System.out.println("Level Order: " + tree.levelOrderData);
    }

    private void levelOrder(Node node, ArrayList<Integer> levelOrderData) {
        if(node == null)
            return;

        Queue<Integer> q = new LinkedList<>();
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
}
