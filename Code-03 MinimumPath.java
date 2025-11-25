package basic;

class Node {
	int val;
	Node left, right;

	Node(int val) {
		this.val = val;
	}
}

public class MinimumPath {
	public static int minPath(Node a) {
		if (a == null)
			return 0 ;
		if (a.left == null && a.right == null)
			return a.val;
		int left = minPath(a.left);
		int right = minPath(a.right);
		return a.val + Math.min(left, right);

	}

	public static void main(String[] args) {
		Node a = new Node(10);
		a.left = new Node(5);
		a.right = new Node(5);
		a.left.right = new Node(2);
		a.right.right = new Node(1);
		a.right.right.left = new Node(-1);
		System.out.println(minPath(a));

	}

}
