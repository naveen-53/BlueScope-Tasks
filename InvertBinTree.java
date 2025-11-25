import java.util.LinkedList;
import java.util.Queue;

class Tree{
    int val;
    Tree left,right;
    Tree(int v){
        val=v;
    }
}
public class InvertBinTree {
    static Tree invert(Tree root){
        if(root==null)
            return null;
        if(root.left!=null || root.right!=null){
            Tree temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        invert(root.left);
        invert(root.right);
        return root;
    }
    static void printLevel(Tree root){
        if(root == null) return;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Tree t = q.poll();
            System.out.print(t.val + " ");
            if(t.left != null) q.add(t.left);
            if(t.right != null) q.add(t.right);
        }
    }


    public static void main(String[] args) {
        Tree root=new Tree(1);
        root.left=new Tree(2);
        root.left.left=new Tree(4);
        root.left.right=new Tree(5);
        root.right=new Tree(3);
        root.right.left=new Tree(6);
        root.right.right=new Tree(7);
        invert(root);
        printLevel(root);
    }
}
