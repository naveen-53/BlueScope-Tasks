package DSA;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode () {}
    TreeNode (int value){
        this.value=value;
    }
    TreeNode (int value,TreeNode left, TreeNode right)
    {
        this.value=value;
        this.left=left;
        this.right=right;
    }
}
public class Problem_5 {
    public TreeNode inverttree(TreeNode root)
    {
        if (root == null )
        {
            return null;
        }
        TreeNode left = inverttree(root.left);
        TreeNode right = inverttree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }
    public static void main(String [] args) {
        TreeNode root = new  TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        Problem_5 p = new Problem_5();
        p.postorder(root);
        System.out.println();
        p.inverttree(root);
        p.postorder(root);
    }
}
