package DSA_Series;

public class Problem_Series_3 {

   static class Tree{
        int val;
        Tree left,right;

        Tree(int val){
            this.val=val;
        }
    }

    static int minimumPath(Tree tree){
        if(tree==null){
            return Integer.MAX_VALUE;
        }
        if(tree.left==null && tree.right==null){
            return tree.val;
        }
        int left=minimumPath(tree.left);
        int right=minimumPath(tree.right);
        return tree.val+Math.min(left,right);

    }

    static void main(String[] args) {
        Tree  t = new Tree(10);
        t.left=new Tree(5);
        t.right=new Tree(5);
        t.left.right=new Tree(2);
        t.right.right=new Tree(1);
        t.right.right.left=new Tree(-1);
        System.out.println(minimumPath(t));
    }

}
