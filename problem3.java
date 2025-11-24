class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) {
this.val = val;
}
TreeNode(int val, TreeNode left, TreeNode right) {
this.val = val;
this.left = left;
this.right = right;
}
}
public class problem3 {
public static void main(String[] args) {


TreeNode root = new TreeNode(10);
root.left = new TreeNode(5);
root.right = new TreeNode(5);
root.left.left=new TreeNode(2);
root.right.right=new TreeNode(1);
root.right.right.left=new TreeNode(-1);
int target = 15;
int sum=0;
Boolean a= check(root,target,sum);
System.out.println(a);

}
static boolean check(TreeNode root, int target,int sum) {
if (root == null) {
return false;
}

sum +=root.val;
System.out.println(sum);
if (root.right == null && root.left == null) {
return sum==target;
}
return check(root.left, target, sum) || check(root.right, target, sum);
}

}
