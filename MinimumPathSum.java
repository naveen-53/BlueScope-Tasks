class Node {
    int val;
    Node left, right;

    Node(int value) {
        this.val = value;
    }
}

public class MinimumPathSum {

    public static int Minimum_Path_Sum(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null)
            return root.val;

        int left_Sum = Minimum_Path_Sum(root.left);
        int rightSUM = Minimum_Path_Sum(root.right);

        return root.val + Math.min(left_Sum, rightSUM);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(5);

        root.left.right = new Node(2);

        root.right.right = new Node(1);
        root.right.right.left = new Node(-1);

        System.out.println(Minimum_Path_Sum(root));
    }
}

