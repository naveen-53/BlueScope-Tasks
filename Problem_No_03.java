package DSA;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class Path {
    public boolean pathsum(TreeNode root,int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == targetSum;
        targetSum -= root.val;
        return pathsum(root.left, targetSum) ||
                pathsum(root.right, targetSum);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(5);
        root.left.right=new TreeNode(2);
        root.right.right=new TreeNode(1);
        root.right.right.left=new TreeNode(-1);
        Path path= new Path();;
        int targetSum = 15;
        if (path.pathsum(root, targetSum))
            System.out.println(targetSum);
        else
            System.out.println("false");
    }
}
