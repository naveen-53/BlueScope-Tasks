package BinarySearchTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class SubTreeChecker {

        public static boolean isSubtree(Node s, Node t) {
        if (t == null) return true;   
        if (s == null) return false;

        if (isSameTree(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null) return true;  
        if (a == null || b == null) return false;  
        if (a.data != b.data) return false;        
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }


    public static void main(String[] args) {
      
        Node s = new Node(3);
        s.left = new Node(4);
        s.right = new Node(5);
        s.left.left = new Node(1);
        s.left.right = new Node(2);

       
        Node t = new Node(4);
        t.left = new Node(1);
        t.right = new Node(2);

        boolean result = isSubtree(s, t);
        System.out.println("t is subtree of s: " + result);
    }
}
