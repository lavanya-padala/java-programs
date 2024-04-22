package redBlackTree;

enum Color
{
	Red,
	Black
}
class Node
{
	public Node left;
	public Node right;
	public Node parent;
	public Color color;
	public int data;
}
class RedBlackTree
{
	private Node root;
	private Node TNULL;
	RedBlackTree(){
		TNULL=new Node();
		TNULL.left=null;
		TNULL.right=null;
		root=TNULL;
		TNULL.color=Color.Black;
	}
	public void Insert(int data) {
		Node node=new Node();
		node.left=TNULL;
		node.right=TNULL;
		node.parent=null;
		node.color=Color.Red;
		node.data=data;
		
		Node x=this.root;
		Node y=null;
		while(x!=TNULL) {
			y=x;
			if(node.data<x.data) {
				x=x.left;
			}
			else {
				x=x.right;
			}
		}
		node.parent=y;
		if(y==null) {
			this.root=node;
		}
		else if(node.data<y.data) {
			y.left=node;
		}
		else if(node.data>y.data) {
			y.right=node;
		}
		
		if(node.parent==null) {
			node.color=Color.Black;
			return;
		}
		if(node.parent.parent==null) {
			return;
		}
		FixInsert(node);
	}
	public void FixInsert(Node k) {
		Node u;
		while(k.parent.color==Color.Red) {
			if(k.parent==k.parent.parent.right)
			{
				u=k.parent.parent.left;
				if(u.color==Color.Red) 
				{
					u.color=Color.Black;
					k.parent.color=Color.Black;
					k.parent.parent.color=Color.Red;
					k=k.parent.parent;
				}
				else {
					if(k==k.parent.left) {
						k=k.parent;
						RightRotate(k);
					}
					k.parent.color=Color.Black;
					k.parent.parent.color=Color.Red;
					LeftRotate(k.parent.parent);
				}
			}
			else {
				u=k.parent.parent.right;
				if(u.color==Color.Red) 
				{
					u.color=Color.Black;
					k.parent.color=Color.Black;
					k.parent.parent.color=Color.Red;
					k=k.parent.parent;
				}
				else {
					if(k==k.parent.right) {
						k=k.parent;
						LeftRotate(k);
					}
					k.parent.color=Color.Black;
					k.parent.parent.color=Color.Red;
					RightRotate(k.parent.parent);
				}
			}
			if(k==root) {
				break;
			}
		}
		root.color=Color.Black;
	}
	public void RightRotate(Node x) {
		Node y=x.left;
		x.left=y.right;
		if(y.right!=TNULL) {
			y.right.parent=x;
		}
		y.parent=x.parent;
		if(x.parent==null) {
			root=y;
		}
		else if(x==x.parent.left) {
			x.parent.left=y;
		}
		else if(x==x.parent.right) {
			x.parent.right=y;
		}
		y.right=x;
		x.parent=y;

	}
	public void LeftRotate(Node x) {
		Node y=x.right;
		x.right=y.left;
		if(y.left!=TNULL) {
			y.left.parent=x;
		}
		y.parent=x.parent;
		if(x.parent==null) {
			root=y;
		}
		else if(x==x.parent.left) {
			x.parent.left=y;
		}
		else {
			x.parent.right=y;
		}
		y.left=x;
		x.parent=y;
	}
	public void Inorder() {
		InorderRec(root);
	}
	public void InorderRec(Node root) {
		if(root!=TNULL) {
			InorderRec(root.left);
			System.out.print(root.data+" ");
			InorderRec(root.right);
		}
	}
	public void Preorder() {
		PreorderRec(root);
	}
	public void PreorderRec(Node root) {
		if(root!=TNULL) {
			System.out.print(root.data+" ");
			PreorderRec(root.left);
			PreorderRec(root.right);
		}
	}
	public static void main(String[] args) {
		RedBlackTree V=new RedBlackTree();
		V.Insert(24);
		V.Insert(33);
		V.Insert(42);
		V.Insert(51);
		V.Insert(60);
		V.Insert(40);
		V.Insert(22);
		System.out.println("Inorder Traversal");
		V.Inorder();
		System.out.println();
		System.out.println("Preorder Traversal");
		V.Preorder();
	}
}