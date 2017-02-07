package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achalise on 6/2/17.
 *
 *Given a  binary tree transform it so that each node has a value that is sum of all the nodes below it
 */
public class BinaryTreeLeafSum {

    public void sumLeafValues(Node root) {
        calculateSum(root);
    }

    private int calculateSum(Node root) {
        if(root == null) {
            return 0;
        }
        root.value = root.value + calculateSum(root.left) + calculateSum(root.right);
        return root.value;
    }


    public void print(Node node) {
        int height = height(node);
        for(int i = 0; i < height * 2; i++) {
            System.out.print(" ");
        }
        System.out.println(node.getValue());
        List<Node> currentNodes = new ArrayList<>();
        currentNodes.add(node);
        List<Node> children = getChildren(currentNodes);
        int level = 1;
        while (!children.isEmpty()) {
            print(children, level, height);
            currentNodes = children;
            children = getChildren(currentNodes);
            level = level + 1;
        }
    }

    private int height(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private void print(List<Node> nodes, int level, int height) {
        for(int i = 0; i < 2 * (height - level); i++) {
            System.out.print(" ");
        }
        for(Node n: nodes) {
            System.out.print(n.value + "   ");
        }
        System.out.println();
    }

    private List<Node> getChildren(List<Node> currentNodes) {
        List<Node> children = new ArrayList<>();
        for(Node node: currentNodes) {
            if(node.left != null) {
                children.add(node.left);
            }
            if(node.right != null) {
                children.add(node.right);
            }
        }
        return children;
    }

    public static void main(String[] args) {
        Node root = new Node(3, null, null);
        root.left = new Node(6, null, null);
        root.right = new Node(4, null, null);
        root.left.left = new Node(2, null, null);
        root.left.right = new Node(8, null, null);

        BinaryTreeLeafSum binaryTreeLeafSum = new BinaryTreeLeafSum();
        binaryTreeLeafSum.print(root);
        binaryTreeLeafSum.sumLeafValues(root);

        System.out.println("After adding leaf values");
        binaryTreeLeafSum.print(root);
    }

}

class Node {
    int value;
    Node left;
    Node right;

    Node() {}

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }
}