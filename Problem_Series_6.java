package DSA_Series;

public class Problem_Series_6 {

    static class Tree{
        char val;

        Tree left;
        Tree right;

        Tree(char val){
            this.val=val;
        }
    }

    public static Tree invertTree(Tree tree){

        if(tree==null){
            return null;
        }
        Tree temp =tree.left;
        tree.left=tree.right;
        tree.right=temp;

        invertTree(tree.left);
        invertTree(tree.right);

        return tree;
    }

    public static void printOrder(Tree tree){
        if(tree==null) return;
        System.out.print(tree.val+" ");
        printOrder(tree.left);
        printOrder(tree.right);
    }

    static void main(String[] args) {

        Tree a = new Tree('a');
        Tree b = new Tree('b');
        Tree c = new Tree('c');
        Tree d = new Tree('d');
        Tree e = new Tree('e');
        Tree f = new Tree('f');

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;

        invertTree(a);
        printOrder(a);
    }



}
