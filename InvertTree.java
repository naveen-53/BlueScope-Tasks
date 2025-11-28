class Node {
    char val;
    Node left, right;

    Node(char v) {
        this.val = v;
    }
}

public class InvertTree {

    public static Node invert(Node root) {
        if (root == null)
            return null;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);

        return root;
    }

    public static void printTree(Node root) {
        if (root == null) 
            return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        a.left = b;  
        a.right = c;
        b.left = d;  
        b.right = e;
        c.left = f;

        Node result = invert(a);
        System.out.print("Inverted Tree (Preorder): ");
        printTree(result);
    }
}
