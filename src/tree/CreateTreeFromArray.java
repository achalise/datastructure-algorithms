package tree;

/**
 * Created by achalise on 14/2/17.
 */
public class CreateTreeFromArray {

    public Node createTree(int[] input) {

        Node n = createTree(input, 0, input.length - 1);

        return n;
    }

    public void printLevelOrder(Node n) {
        int height = height(n);
        for(int i = 1; i <= height; i++) {
            printLevelOrder(n,  i);
        }
    }

    private void printLevelOrder(Node n, int level) {
        if(n == null) {
            return;
        } else if(level == 1) {
            System.out.print(n.val + " ");
        } else {
            printLevelOrder(n.left, level - 1);
            printLevelOrder(n.right, level -1);
        }
        //System.out.println();
    }

    private int height(Node n) {
        if(n == null) {
            return 0;
        } else {
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }

    private Node createTree(int[] input, int start, int end) {
        if(start > end) {
            return null;
        } else {
            int mid = (start + end) / 2;
            Node n = new Node(input[mid]);
            n.left = createTree(input, start, mid - 1);
            n.right = createTree(input, mid + 1, end);

            return n;
        }

    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node() {}

        Node(int val) {
            this.val = val;
        }

        public void addLeft(Node n) {
            this.left = n;
        }

        public void addRight(Node n) {
            this.right = n;
        }

        public Node getRight() {
            return this.right;
        }

        public Node getLeft() {
            return this.left;
        }
    }

    public static void main(String[] args) {
        CreateTreeFromArray solution = new CreateTreeFromArray();
        Node n = solution.createTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        System.out.println("height of the tree is " + solution.height(n));
        solution.printLevelOrder(n);
    }

}
