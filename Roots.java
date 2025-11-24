class Roots{
	int val;
	Roots left, right;

	Roots(int v){
		this.val = v;
	}
}


public class Minpath{

 	public int minpath(Roots root){
		if(root == null)
			return INTEGER.MAX_VALUE;
		if(root.left == null && root.right == null)
			return root.val;
		return root += Math.min(maxpath(root.left),maxpath(root.right));
  	}


  	public static void main(String args[]){
		Roots root = new Roots(10);
		root.left = new Roots(5);
		root.left.right = new Roots(2);

		root.right = new Roots(5);
		root.right.right = new Roots(1);
		root.right.right.left = new Roots(-1);  

		Minpath obj = new Minpath();
		int result = obj.minpath(root);
  	}

}

