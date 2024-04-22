package avltree;
class Node
{
	public int data,height;
	public Node left,right;
	public Node(int data) {
		this.data=data;
		height=1;
		left=right=null;
	}
}
public class AVLTree
{
	  private Node root;
	
	  public AVLTree() {
	      root = null;
	  }
	
	  private int Height(Node node) {
	      if (node == null)
	          return 0;
	      return node.height;
	  }
	  
	  private int GetBalance(Node root) {
		  if(root==null)
			  return 0;
		  else 
			  return Height(root.left)-Height(root.right);
	  }
	  
	  private Node RotateRight(Node y) {
		  Node x=y.left;
		  Node T2=x.right;
		  
		  x.right=y;
		  y.left=T2;
		  
		  y.height=1+Math.max(Height(y.left),Height(y.right));
		  x.height=1+Math.max(Height(x.left),Height(x.right));
		  
		  return x;
	  }
	  
	  private Node RotateLeft(Node x) 
	  {
		  Node y=x.right;
		  Node T2=y.left;
		  
		  y.left=x;
		  x.right=T2;
		  
		  y.height=1+Math.max(Height(y.left),Height(y.right));
		  x.height=1+Math.max(Height(x.left),Height(x.right));
		  
		  return y;
	  }
	  
	  public void insert(int data) {
		  root=insertRec(root,data);
	  }
	  
	  private Node insertRec(Node root,int data) {
		  if(root==null) {
			  return new Node(data);
		  }
		  else if(data<root.data) {
			  root.left=insertRec(root.left,data);
		  }
		  else if(data>root.data) {
			  root.right=insertRec(root.right,data);
		  }
		  else {
			  return root;// duplicates not allowed
		  }
		  root.height=1+Math.max(Height(root.left),Height(root.right));
		  int balance=GetBalance(root);
		  //left left rotation
		  if(balance>1&&data<root.left.data) {
			  return RotateRight(root);
		  }
		  if(balance>1&&data>root.left.data) {
			  root.left=RotateLeft(root.left);
			  return RotateRight(root);
		  }
		  if(balance<-1&&data>root.right.data) {
			  return RotateLeft(root);
		  }
		  if(balance<-1&&data<root.right.data) {
			  root.right=RotateRight(root.right);
			  return RotateLeft(root.left);
		  }
		  return root;
	  }
	  
	  public void delete(int data) {
		  root=deleteRec(root,data);
	  }
	  private Node deleteRec(Node root,int data) {
		  if(root==null) {
			  return root;
		  }
		  if(data<root.data) {
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
	  private int minVal(Node root) 
	  {
		  int value=root.data;
		  while(root.left!=null) {
			  value=root.left.data;
			  root=root.left;
		  }
		  return value;
	  }
	  public void inorder() {
		  inorderRec(root);
	  }
	  private void inorderRec(Node root) {
		  if(root!=null) {
			  inorderRec(root.left);
			  System.out.print(root.data+" ");
			  inorderRec(root.right);
		  }
	  }
	  public static void main(String[] args) {
		  AVLTree avltree=new AVLTree();
		  avltree.insert(10);
		  avltree.insert(20);
		  avltree.insert(30);
		  avltree.insert(40);
		  avltree.insert(50);
		  avltree.insert(60);
		  avltree.delete(30);
		  System.out.println("InOrder Traversal:");
		  avltree.inorder();
		
		
	  }
}
//class Node {
//    public int data;
//    public Node left, right;
//    public int height;
//
//    public Node(int data) {
//        this.data = data;
//        height = 1;
//    }
//}
//
//public class AVLTree {
//    private Node root;
//
//    public AVLTree() {
//        root = null;
//    }
//
//    private int Height(Node node) {
//        if (node == null)
//            return 0;
//        return node.height;
//    }
//
//    private int GetBalance(Node node) {
//        if (node == null)
//            return 0;
//        return Height(node.left) - Height(node.right);
//    }
//
//    private Node RotateRight(Node y) {
//        Node x = y.left;
//        Node T2 = x.right;
//
//        x.right = y;
//        y.left = T2;
//
//        y.height = Math.max(Height(y.left), Height(y.right)) + 1;
//        x.height = Math.max(Height(x.left), Height(x.right)) + 1;
//
//        return x;
//    }
//
//    private Node RotateLeft(Node x) {
//        Node y = x.right;
//        Node T2 = y.left;
//
//        y.left = x;
//        x.right = T2;
//
//        x.height = Math.max(Height(x.left), Height(x.right)) + 1;
//        y.height = Math.max(Height(y.left), Height(y.right)) + 1;
//
//        return y;
//    }
//
//    public void Insert(int data) {
//        root = InsertRec(root, data);
//    }
//
//    private Node InsertRec(Node root, int data) {
//        if (root == null)
//            return new Node(data);
//
//        if (data < root.data)
//            root.left = InsertRec(root.left, data);
//        else if (data > root.data)
//            root.right = InsertRec(root.right, data);
//        else
//            return root; // Duplicate data not allowed
//
//        root.height = 1 + Math.max(Height(root.left), Height(root.right));
//
//        int balance = GetBalance(root);
//        //left left case
//        if (balance > 1 && data < root.left.data)
//            return RotateRight(root);
//        //right right case
//        if (balance < -1 && data > root.right.data)
//            return RotateLeft(root);
//        //left right case
//        if (balance > 1 && data > root.left.data) {
//            root.left = RotateLeft(root.left);
//            return RotateRight(root);
//        }
//        //right left case
//        if (balance < -1 && data < root.right.data) {
//            root.right = RotateRight(root.right);
//            return RotateLeft(root);
//        }
//
//        return root;
//    }
//
//    public void Delete(int data) {
//        root = DeleteRec(root, data);
//    }
//
//    private Node DeleteRec(Node root, int data) {
//        if (root == null)
//            return root;
//
//        if (data < root.data)
//            root.left = DeleteRec(root.left, data);
//        else if (data > root.data)
//            root.right = DeleteRec(root.right, data);
//        else {
//            if (root.left == null || root.right == null) {
//                Node temp = (root.left != null) ? root.left : root.right;
//
//                if (temp == null) {
//                    temp = root;
//                    root = null;
//                } else
//                    root = temp;
//            } else {
//                Node temp = MinValueNode(root.right);
//                root.data = temp.data;
//                root.right = DeleteRec(root.right, temp.data);
//            }
//        }
//
//        if (root == null)
//            return root;
//
//        root.height = 1 + Math.max(Height(root.left), Height(root.right));
//
//        int balance = GetBalance(root);
//
//        if (balance > 1 && GetBalance(root.left) >= 0)
//            return RotateRight(root);
//
//        if (balance > 1 && GetBalance(root.left) < 0) {
//            root.left = RotateLeft(root.left);
//            return RotateRight(root);
//        }
//
//        if (balance < -1 && GetBalance(root.right) <= 0)
//            return RotateLeft(root);
//
//        if (balance < -1 && GetBalance(root.right) > 0) {
//            root.right = RotateRight(root.right);
//            return RotateLeft(root);
//        }
//
//        return root;
//    }
//
//    private Node MinValueNode(Node node) {
//        Node current = node;
//
//        while (current.left != null)
//            current = current.left;
//
//        return current;
//    }
//
//    public void InOrder() {
//        InOrderRec(root);
//    }
//
//    private void InOrderRec(Node root) {
//        if (root != null) {
//            InOrderRec(root.left);
//            System.out.print(root.data + " ");
//            InOrderRec(root.right);
//        }
//    }
//
//    public static void main(String[] args) {
//        AVLTree tree = new AVLTree();
//
//        tree.Insert(9);
//        tree.Insert(5);
//        tree.Insert(10);
//        tree.Insert(0);
//        tree.Insert(6);
//        tree.Insert(11);
//        tree.Insert(-1);
//        tree.Insert(1);
//        tree.Insert(2);
//
//        System.out.println("Inorder traversal of the constructed tree:");
//        tree.InOrder();
//        System.out.println();
//
//        System.out.println("Delete 10");
//        tree.Delete(10);
//        System.out.println("Inorder traversal of the modified tree:");
//        tree.InOrder();
//        System.out.println();
//    }
//}
