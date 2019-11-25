/******************************************************************************

 *  Purpose: Linked List Implementation
 *
 *  @author  Shivani Kumari
 *  @version 1.0
 *  @since   6-11-2019
 *
 ******************************************************************************/

/*
 * PACKAGE NAME
 */
package com.bridgelabz.stockaccountmanagement.utility;

import java.io.File;
import java.io.PrintStream;

import com.bridgelabz.stockaccountmanagement.model.CompanyDetails;

/*
 * Generic LinkedList class.
 * 
 * @param <T> the type of the value
 */
public class LinkedList<T> {

	Node<T> head;
	/*
	 * Creating Object of the company Details Class
	 */
	public static CompanyDetails company = new CompanyDetails();

	/*
	 * creating the Node Class
	 */
	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	/*
	 * Method to add the data
	 */
	public void add(T data) {
		Node<T> n = new Node<T>(data);

		if (head == null) {
			head = n;
		} else {
			Node<T> t = head;
			while (t.next != null) {
				t = t.next;
			}
			t.next = n;
		}
	}

	/*
	 * Method to search the data
	 */
	public boolean search(T item) {
		int c = 0;
		if (head == null) {
			return false;
		} else {
			Node<T> t = head;
			while (t != null) {
				if (item.equals(t.data)) {
					c++;
					break;
				}
				t = t.next;
			}
		}
		if (c > 0)
			return true;
		else
			return false;
	}

	/*
	 * method to append the data
	 */
	public void append(T data) {
		Node<T> n = new Node<T>(data);
//		n.data = data;
//		n.next = null;
		Node<T> t = head;
		while (t.next != null) {
			t = t.next;
		}
		t.next = n;
	}

	/*
	 * method to display
	 */
	public void display() {
		Node<T> t = head;
		while (t != null) {
			System.out.println(t.data.toString());
			t = t.next;
		}

	}

	/*
	 * Method to write
	 */
	public void write() throws Exception {
		Node<T> temp = head;
		try {
			PrintStream o = new PrintStream(new File("/home/admin1/Downloads/BridgeLabz/StockAccount"));
			System.setOut(o);
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	/*
	 * Method to give index Value
	 */
	public int index(T item) {
		int count = 0, i = 0;
		if (head == null) {
			return -1;
		} else {
			Node<T> temp = head;
			while (temp != null) {
				i++;
				if (item == temp.data) {
					count++;
					break;
				}
				temp = temp.next;
			}
		}
		if (count > 0)
			return i;
		else
			return -1;

	}

	/*
	 * Method To delete data
	 */
	public void pop() {
		Node<T> temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp = null;
		head = null;
	}

	/*
	 * Method To Delete at the Specific Positon
	 */
	public void pop(T data) {
		Node<T> temp = head, prev = null;

		if (temp.data.equals(data)) {
			head = temp.next;
			return;
		}

		while (temp != null && !temp.data.equals(data)) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;

	}

	/*
	 * Method to check list Empty or not
	 */
	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	/*
	 * Method to check size
	 */
	public int size() {
		int i = 0;
		if (head == null)
			return 0;
		else {
			Node<T> temp = head;
			while (temp != null) {
				temp = temp.next;
				i++;
			}
		}
		return i;
	}

	/*
	 * Method to remove Data
	 */
	public void remove(T data) {
		Node<T> temp = head, prev = null;

		if (temp.data.equals(data)) {
			head = temp.next;
			return;
		}

		while (temp != null && !temp.data.equals(data)) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;

	}

	/*
	 * Method to inset data
	 */
	public void insert(int index, T data) {
		Node<T> new_Node = new Node<T>(data);
		new_Node.data = data;
		new_Node.next = null;
		if (index == 0) {
			addFirst(data);
		} else {
			Node<T> temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			new_Node.next = temp.next;
			temp.next = new_Node;
		}
	}

	/*
	 * Method to add At first
	 */
	public void addFirst(T data) {
		Node<T> new_Node = new Node<T>(data);
		Node<T> temp = head;
		new_Node.next = temp;
		head = new_Node;

	}

	/*
	 * Method to sort
	 */
	public void sort(T i) {
		Node<T> temp, a, prev, pos;
		pos = new Node<T>(i);
		pos.next = head;
		head = pos;
		while (pos.next != null) {
			temp = pos.next;
			prev = pos;
			a = temp.next;
			while (a != null) {
				if (((String) a.data).compareTo((String) temp.data) > 0) {
					Node<T> tempOne = a.next;
					a.next = prev.next;
					prev.next = temp.next;
					temp.next = tempOne;
					prev = a;
					a = tempOne;
				} else {
					a = a.next;
					temp = temp.next;
					prev = prev.next;
				}
			}
			pos = pos.next;
			head = head.next;
		}
	}

	public static void main(String[] args) {
		LinkedList<Object> list = new LinkedList<Object>();
		System.out.println("Linked List data");
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.display();

		boolean result = list.search(300);
		if (result)
			System.out.println("Data present in the list\n");
		else
			System.out.println("Data not present in the list\n");

		System.out.println("Append:\n");
		list.append(50);
		list.display();

//		System.out.println("Write:\n");
//		try {
//			list.write();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		System.out.println("Index:\n");
		int resultOne = list.index(200);
		if (result) {
			System.out.println(resultOne);
		} else {
			System.out.println("Invalied Input");
		}

//		System.out.println("Pop\n");
//		list.pop();
		list.display();

		System.out.println("Pop at the specific Position");
		list.pop(20);
		list.display();

		System.out.println("Sort:\n");
//		list.sort(20);
		list.display();

//		list.addElementFirst(5);
//		list.insertAtPosition(15, list.head, 2);
//		list.display();
//		list.reverse(list.head);
//		list.display();
//		list.append(40);
//		System.out.println("Insert at last");
//		list.display();
//		System.out.println("Deletion at first");
//		list.delet(5);
//		System.out.println("Delete\n");
//		list.display();
//		System.out.println("Deletion at mid");
//		list.display();
//		list.deleteAtMid(20, list.head);
//		list.display();
//		System.out.println("Deleting the node at last");
//		list.deleteAtEnd(list.head);
//		list.display();
//		System.out.println("search element");
//		boolean result = list.search(200);
//		if (result) {
//			System.out.println("Element Found in the list");
//		} else {
//			System.out.println("Element not found in the list");
//		}
//
//		list.display();
//		System.out.println("size");
//		list.size(list.head);
//
//		try {
//			list.index(200);
//		} catch (Exception e) {
//			System.out.println("Invalied item");
//		}
//
//		list.removeAll(list);
//		System.out.println("Data remove Succesfully");
//		list.display();

//		/*
//		 * System.out.println("Enter 1 for add");
//		 * System.out.println("Enter 2 for insert at fast");
//		 * System.out.println("Enter 3 for insert at mid");
//		 * System.out.println("Enter 4 for insert at last");
//		 * System.out.println("Enter 5 for reverse");
//		 * System.out.println("Enter 6 for delet at first");
//		 * System.out.println("Enter 7 for delet at mid");
//		 * System.out.println("Enter 8 for delet at last"); System.out.println("Exit");
//		 */
	}

}
