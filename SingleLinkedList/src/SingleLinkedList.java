public class SingleLinkedList {
	public class Node
	{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	public void insertBeginning(int data) {
		Node newnode=new Node(data);
		newnode.next=head;
		head=newnode;
		System.out.println(data+" inserted at beginning of linked list");
	}
	public void insertEnding(int data) {
		if(head==null) {
			head=new Node(data);
			System.out.println(data+" inserted at end of linked list");
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			Node newNode=new Node(data);
			temp.next=newNode;
			System.out.println(data+" inserted at end of linked list");
		}
	}
	public int calcSize() {
		if(head==null) {
			return 0;
		}
		else {
			Node temp=head;
			int size=0;
			while(temp!=null) {
				size++;
				temp=temp.next;
			}
			return size;
		}
	}
	public void insertAfterPosition(int n,int data) {
		if(n<1||n>calcSize()) {
			System.out.println("Postion n is out of range of Linkedlist");
		}
		else {
			Node temp=head;
			while(--n>0)
				temp=temp.next;
			Node newNode=new Node(data);
			newNode.next=temp.next;
			temp.next=newNode;
			System.out.println(data+" inserted at after position "+n);
		}
		
	}
	public void insertBeforePosition(int n,int data) {
		if(n<1||n>calcSize()) {
			System.out.println("Postion n is out of range of Linkedlist");
		} 
		else {
			Node temp=head;
			--n;
			while(--n>0)
				temp=temp.next;
			Node newNode=new Node(data);
			newNode.next=temp.next;
			temp.next=newNode;
			System.out.println(data+" inserted at after position "+n);
		}
	}
	public void deleteBeginning() {
		if(head==null) {
			System.out.println("Linked list is empty");
		}
		else {
			System.out.println(head.data+" deleted from linked list beginning");
			head=head.next;
		}
	}
	public void deleteEnding() {
		if(head==null) {
			System.out.println("Linked list is empty");
		}
		else if(head.next==null) {
			System.out.println(head.data+" deleted from linked list ending");
			head=null;
		}
		else {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			System.out.println(temp.next.data+" deleted from linked list ending");
			temp.next=null;
		}
	}
	public void deletePosition(int n) {
		if(head==null) {
			System.out.println("Linked list is empty");
		}
		else if(n<1||n>calcSize()) {
			System.out.println("Postion n is out of range of Linkedlist");
		} 
		else if(n==1) {
			deleteBeginning();
		}
		else {
			int num=n;
			Node temp=head;
			--n;
			while(--n>0)
				temp=temp.next;
			System.out.println(temp.next.data+" deleted from linked list at position "+num);
			temp.next=temp.next.next;
		}
	}
	public void display() {
		if(head==null) {
			System.out.println("Linked list is empty");
		}
		else {
			System.out.println("Elements in LinkedList:");
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		SingleLinkedList sll=new SingleLinkedList();
		sll.display();
		sll.insertBeginning(20);
		sll.insertBeginning(10);
		sll.insertEnding(30);
		//System.out.println(sll.calcSize());
		sll.insertAfterPosition(3, 15);
		sll.insertBeforePosition(4, 12);
		sll.display();
		sll.deleteBeginning();
		sll.deleteEnding();
		sll.display();
		sll.deletePosition(1);;
		sll.display();
	}
}
