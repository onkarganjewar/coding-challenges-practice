package sll;

import java.util.ArrayList;

public class SinglyLL {

	Node head;

	public void insert_end(int data) {
		if (head == null) {
			this.head = new Node(data);
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node temp = new Node(data);
			current.next = temp;
		}

	}

	public void insert_nth(int data, int pos) {
		Node current = this.head;
		/*
		 * suppose we have 10->20->30->40->50 kind of linked list now if we want
		 * to insert element at 3rd position that is after 20 then exit the loop
		 * at 20 viz., i=0 and i=1 iteration now when pos is 3 then we have to
		 * iterate pos-2 times to get only 2 iterations
		 */
		for (int i = 0; i < pos - 2; i++) {
			current = current.next;
		}

		/*
		 * at this point we have current as 20 now new node is 90 so
		 * 10->20->30->40->50 becomes 10->20->90->30->40->50 that is 20.next =
		 * newnode and newnode.next = old20.next
		 *
		 */
		System.out.println("Current is " + current.data);
		Node old = current;
		Node nextold = current.next;
		Node newnode = new Node(data);
		current.next = newnode;
		newnode.next = nextold;

	}

	public void insert_begin(int data) {
		if (head == null) {
			this.head = new Node(data);
		} else {
			Node n = new Node(data);
			n.next = this.head;
			this.head = n;
		}

	}

	public void print() {
		Node curr = this.head;
		// System.out.println("linked list is");
		while (curr != null) {
			System.out.print(" " + curr.data);
			curr = curr.next;
		}
		// System.out.print(" "+curr.data);

	}

	public void reverse_it() {
		// Node prev;
		Node next = null;
		Node prev = null;
		Node current = this.head;

		if (current.next == null) {
			System.out.println("Only one node in the list");
		} else {
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
		}
		this.head = prev;
		// System.out.println("Previous that is renewed head is "+prev.data);
		// System.out.println("Previos next is "+prev.next.data);
	}

	// consider linked list as 10=>20=>30

	public void reverse_rec(Node n) // consider the n is at 10
									// second(first recursive) call as 20
									// third call as 30
	{
		Node current = n;
		if (n.next == null) // first(main) call n = 10 n.next =20
							// second call n= 20 n.next =30
							// 30.next == null enter the loop
		{
			this.head = current; // set head at 30
			return; // exit the call {30 is successful)
		}

		reverse_rec(current.next); // first iteration current.next = 20
									// second call n.next = 30
									// 30 pops out of the stack and 20 comes
									// above
									// now 20 pops out of the stack and 10 comes
									// up

		// now current.next is 20
		// for last call current.next is 10
		current.next.next = current; // 20.next.next = 20 --- 20==>30==>20
										// 10.next.next = 10 --- 10-->20==>10

		current.next = null; // 20.next = null so 10-->20 30-->20 (first link
								// broken)
								// 10.next = null so 10-->null 30-->20-->10
								// so the list becomes 30-->20-->10-->null

	}

	public void delete_nth(int pos) {
		if (pos == 2) {
			Node c = this.head.next;
			this.head.next = c.next;
		} else {

			Node current = this.head;
			for (int i = 0; i < pos - 2; i++) {
				current = current.next;
			}
			Node temp = current.next;
			current.next = temp.next;

		}
	}

	public void delete_head() {
		Node current = this.head;
		this.head = current.next;
	}

	public void delete_tail() {
		Node tail = null;
		Node current = this.head;
		while (current.next != null) {
			tail = current;
			current = current.next;
		}
		tail.next = null;
	}

	public void find(int data) {
		int i = 1;
		Node current = this.head;
		while (current != null) {
			if (current.data == data) {
				System.out.println("\nData found at location " + i);
				return;
			}
			current = current.next;
			i++;
		}
		System.out.println("Data not found ");
	}

	public int searchRec(Node head, int data) {
		Node temp;
		Node current = head;
		if (current.data == data) {
			return 1;
		}
		searchRec(current.next, data)
	}
	public static void main(String[] args) {

		SinglyLL m = new SinglyLL();
		m.insert_begin(20);
		m.insert_begin(10);
		m.insert_end(30);
		m.insert_end(40);
		// m.insert_end(50);
		// Node sample = head;

		// System.out.println("\nList after inserting 90 at 3rd position");
		// m.insert_nth(90, 3);
		System.out.println("Before Reverse");
		m.print();
		m.reverse_it();// iterative method
		System.out.println("\nReverse using iterative method");
		m.print();
		m.reverse_rec(m.head);// using recursion
		System.out.println("\nReverse using recursion");
		m.print();
		// System.out.println("List after deleting third element");
		// m.delete_nth(3);
		// System.out.println("List after tail is cut off");
		// m.delete_tail();
		// m.print();
		// System.out.println("List after head is cut off");
		// m.delete_head();
		// m.print();
		m.find(20);

	}
}
