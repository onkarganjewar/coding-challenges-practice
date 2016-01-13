import javax.swing.plaf.synth.SynthSeparatorUI;

public class DoublyLL {
	Node head = null ;
	Node last;
	public void insert(int data, Node n)
	{
		Node temp = new Node();
		Node current = this.head;
		temp.data = data;
		temp.next = null;
		temp.prev = null;
		if (current == null)
		{
			current = temp;
			current.prev = null;
			current.next = null;
			this.head = current;
			return;
		}
		else
		{
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = temp;
			temp.prev = current;
		}

	}
	public void display()
	{
		Node current = this.head;
		int i = 1;
		if (current == null) {
			System.out.println("Empty Linked list");
			return;
		}
		else if (current.next == null)
		{
			System.out.println("[ "+current.data+" ]");
			return;
		}
		else
		{
			System.out.print("[");
			while (current.next!= null)
			{
				System.out.print(" "+current.data+",");
				current = current.next;
				i++;
			}
			System.out.print(" "+current.data+" ]");
		}
	}

	public void insert_begin(int data, Node n)
	{
		Node current = this.head;
		Node temp = n;
		temp.data = data;
		temp.prev = null;

		if(current == null)
		{
			current = temp;
			this.head = current;
		}
		else
		{
			current.prev = temp;
			temp.next = current;
			temp.prev = null;
			this.head = temp;
		}
	}

	//Inserting an element in the linked list at the position k with data d
	public void insert_nth(int k, int d)
	{
		Node current = this.head;
		Node prev,next;
		Node newnode = new Node();
		newnode.data = d;
		newnode.next = null;

		if (current.next == null)
		{
			current.next = newnode;
			newnode.prev = current;
			newnode.next = null;
			return;
		}

		for (int i=1; i<k ; i++)
		{
			current = current.next;
		}

		prev = current.prev;
		prev.next = newnode;
		newnode.next = current;
		newnode.prev = prev;
	}


	//Reversing the linked list using iterative method
	public void reverse_it()
	{
		Node current = this.head;
		Node tail = this.head; //saving the head pointer
		Node temp = new Node();
		temp.data = 0;

		if(current == null)
		{
			System.out.println("Empty Linked List");
			return;
		}

		while (tail.next!= null)
		{
			tail = tail.next; //setting the tail at the end of the linked list
		}

		while(current != null)
		{
			temp = current.next;
			current.next = current.prev;
			current.prev = temp;
			current = temp;
		}
		this.head = tail;
	}


	//Reversing the linked list using iterative method
	public void reverse_rec(Node n)
	{
		Node current = n;
		Node head = this.head;
		Node tail = this.head; //saving the head pointer
		Node temp;

		if(current == null)
		{
			while (tail.next!= null)
			{
				tail = tail.next; //setting the tail at the end of the linked list
			}
			this.head = tail;
			return;
		}

			reverse_rec(current.next);

			temp = current.next;
			current.next = current.prev;
			current.prev = temp;
	}






	public void delete_nth (int k)
	{
		Node prev,next;
		Node current = this.head;

		if(current == null)
		{
			System.out.println("Empty Linked List");
			return;
		}
		else if (current.next == null)
		{
			System.out.println("Only one node in the linked list");
			this.head = null;
			return;
		}

		for (int i = 1; i<k ; i++)
		{
			current = current.next;
		}

		if(current.next == null)
		{
			prev = current.prev;
			prev.next = null;
		}
		else
		{
			next = current.next;
			prev = current.prev;
			prev.next = next;
			next.prev = prev;
		}
	}

	public void delete_head() {
		Node current = this.head;
		Node next;
		if(current == null)
		{
			System.out.println("Empty Linked List");
			return;
		}
		else if (current.next == null)
		{
			System.out.println("Only one node in the linked list");
			this.head = null;
			System.out.println("Head is deleted");
			return;
		}
		next = current.next;
		next.prev = null;
		this.head = next;
	}

	public void display_reverse() {

		Node current = this.head;
		if (current == null)
		{
			System.out.println("Empty Linked list");
			return;
		}
		else if(current.next == null)
		{
			System.out.println("Only one node in the linked list");
			System.out.println("[ "+current.data+" ]");
			return;
		}
		while (current.next != null)
		{
			current = current.next;
		}
		//System.out.println("Reversed linked list");
		System.out.print("[");
		while (current.prev != null)
		{
			System.out.print(" "+current.data+",");
			current = current.prev;
		}
		System.out.print(" "+current.data+" ]");
	}

	public static void main(String[] args) {
		DoublyLL dl = new DoublyLL();
		Node t = dl.head;
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		dl.insert(20, b);
	//	dl.delete_nth(1);
		dl.insert(30, d);
		dl.display();

		dl.insert_begin(10, c);
		System.out.println("\nLinked List after inserting 10 at the beginning ");
		dl.display();

		System.out.println("\nPrinting the linked list in the reverse order");
		dl.display_reverse();

		dl.insert_nth(2, 22);
		System.out.println("\nLinked List after inserting element 22 at the 2nd position");
		dl.display();


		dl.delete_nth(2);
		System.out.println("\nLinked List after deletion of second element");
		dl.display();
/*
		dl.delete_head();
		System.out.println("\nLinked list after removal of the head");
		dl.display();


		System.out.println("\nReversing of the linked list");
		dl.reverse_it();
		dl.display();
*/
		System.out.println("\nReversing of the linked list using recursion");
		dl.reverse_rec(dl.head);
		dl.display();
	}
}


/*Output :

[ 20, 30 ]
Linked List after inserting 10 at the beginning
[ 10, 20, 30 ]
Printing the linked list in the reverse order
[ 30, 20, 10 ]
Linked List after inserting element 22 at the 2nd position
[ 10, 22, 20, 30 ]
Linked List after deletion of second element
[ 10, 20, 30 ]
Reversing of the linked list using recursion
[ 30, 20, 10 ]

*/
