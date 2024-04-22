package binarySearchTree;

public class BinarySearchTree {
	public class Node{
		public int data;
		public Node left;
		public Node right;
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	public Node root;
	BinarySearchTree(){
		this.root=null;
	}
	public void insert(int data) {
		root=insertRec(root,data);
	}
	public Node insertRec(Node root,int data) {
		if(root==null) {
			root=new Node(data);
			return root;
		}
		if(data<root.data) {
			root.left=insertRec(root.left,data);
		}
		else if(data>root.data) {
			root.right=insertRec(root.right,data);
		}
		return root;
	}
	public void inorder() {
		inorderRec(root);
	}
	public void inorderRec(Node root) {
		if(root!=null) {
			inorderRec(root.left);
			System.out.print(root.data+" ");
			inorderRec(root.right);
		}
	}
	public void preorder() {
		preorderRec(root);
	}
	public void preorderRec(Node root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}
	public void postorder() {
		postorderRec(root);
	}
	public void postorderRec(Node root) {
		if(root!=null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data+" ");
		}
	}
	public void delete(int data) {
		root=deleteRec(root,data);
	}
	public Node deleteRec(Node root,int data) {
		if(root==null) {
			return root;
		}
		else if(data<root.data) {
			root.left=deleteRec(root.left,data);
		}
		else if(data>root.data) {
			root.right=deleteRec(root.right,data);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			root.data=minVal(root.right);
			root.right=deleteRec(root.right,root.data);
		}
		return root;
	}
	 public boolean search(int key) {
	        return searchRec(root, key);
	    }

	    private boolean searchRec(Node root, int data) {
	        if (root == null || root.data== data) {
	            return root != null;
	        }

	        if (data < root.data) {
	            return searchRec(root.left, data);
	        } else {
	            return searchRec(root.right, data);
	        }
	    }

	public int minVal(Node root) {
		int min=root.data;
		while(root.left!=null) {
			min=root.left.data;
			root=root.left;
		}
		return min;
	}
	public static void main(String args[]) {
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
	//	bst.insert(5);
		bst.delete(20);
		System.out.println("Inorder Traversal of Binary tree:");
		bst.inorder();
		System.out.println();
//		System.out.println("Preorder Traversal of Binary tree:");
//		bst.preorder();
//		System.out.println();
////		bst.delete(20);
//		System.out.println("Postorder Traversal of Binary tree:");
//		bst.postorder();
//		System.out.println();
//		System.out.println(bst.search(10));
//		System.out.println(bst.search(50));

	}
}
