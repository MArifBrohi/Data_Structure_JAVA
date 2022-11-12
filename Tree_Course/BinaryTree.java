import java.util.Scanner;
class Node{
	int data;
	Node left ,  right;
	// parametrized constructor
	Node(int data){
		this.data = data;
		right = null;
		left = null;
	}
	// default constructor
	Node (){
		this.data = 0;
		left = right = null;
	}
}
public class Tree{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data: ");
		int rootdatat = sc.nextInt();
	Node root = new Node(rootdatat);
		System.out.println("Enter left child data: ");
		int leftchild = sc.nextInt();
		System.out.println("Enter right child data: ");
		int rightchild = sc.nextInt();
	root.left = new Node(leftchild);
	root.right = new Node(rightchild);
	// in order traversal
	System.out.println(root.left.data+" "+root.data+" "+root.right.data);
	}
}
	
