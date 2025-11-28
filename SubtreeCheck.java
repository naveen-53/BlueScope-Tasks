class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { 
        val = x; 
    }
}

public class SubtreeCheck {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) 
            return false;    
        if (isSame(s, t)) 
           return true; 
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
 
    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) 
            return true;
        if (a == null || b == null) 
            return false;
        if (a.val != b.val) 
            return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        SubtreeCheck obj = new SubtreeCheck();
        System.out.println(obj.isSubtree(s, t));
    }
}