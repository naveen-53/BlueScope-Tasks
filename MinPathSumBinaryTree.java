package BinarySearchTree;

class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
public class MinPathSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(5);

        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(-1);

        int minSum = minRootToLeafSum(root);
        System.out.println("Minimum Root-to-Leaf Path Sum: " + minSum);
    }

    public static int minRootToLeafSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree must not be empty");
        }
        return helper(root);
    }

    private static int helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left == null) {
            return node.val + helper(node.right);
        }

        if (node.right == null) {
            return node.val + helper(node.left);
        }

        return node.val + Math.min(helper(node.left), helper(node.right));
    }
}
