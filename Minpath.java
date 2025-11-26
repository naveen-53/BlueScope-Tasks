import java.util.*;
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
			return Integer.MAX_VALUE;
		if(root.left == null && root.right == null)
			return root.val;
		return root.val + Math.min(minpath(root.left),minpath(root.right));
  	}


	public static Roots createTree(Scanner sc) {
        	System.out.print("Enter node value or 'null' for null: ");
       		String input = sc.nextLine();

        	if (input.equalsIgnoreCase("null")){
            		return null;
		}
        	int value = Integer.parseInt(input);
		Roots root = new Roots(value);

       		System.out.println("Enter LEFT child of " + value);
        	root.left = createTree(sc);

       		System.out.println("Enter RIGHT child of " + value);
        	root.right = createTree(sc);

        	return root;
    	}

  	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        	System.out.println("Create your tree:");
        	Roots root = createTree(sc);

       	 	Minpath obj = new Minpath();
        	int result = obj.minpath(root);

        	System.out.println("Minimum Path Sum = " + result);
  	}

}

