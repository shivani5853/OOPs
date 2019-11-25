/******************************************************************************

 *  Purpose: Stack implementation
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

/*
 * Generic version of the LinkedList class.
 * 
 * @param <T> the type of the value
 */
public class Stack<T> {

	Node<T> head;
	int count = 0;

	class Node<T> {
		Node<T> next;
		T data;

		Node(T data) {
			this.data = data;
		}
	}

	public Stack() {
		this.head = null;
	}

	/*
	 * PUSH THE DATA
	 */
	public void push(T data) {
		Node<T> new_node = new Node<T>(data);
		new_node.next = head;
		head = new_node;
		count++;
	}

	/*
	 * POP THE DATA
	 */
	public void pop() {
		if (head == null) {
			System.out.println("Stack UnderFlow");
			return;
		}
		Node<T> temp = head;
		head = temp.next;
		temp = null;
		count--;
	}

	/*
	 * CHECK PEEK
	 */
	public T peek() {
		if (head == null) {
			System.out.println("no data present");
		}
		T temp = head.data;
		return temp;
	}

	/*
	 * TO FIND SIZE
	 */
	public int size() {
		return count;

	}

	/*
	 * CHECK EMPTY
	 */
	public boolean isEmpty() {
		if (count == 0) {
			return false;
		}
		return true;

	}

	/*
	 * DISPLAY THE DATA
	 */
	public void display() {
		Node<T> temp = head;
		if (temp == null) {
			System.out.println("Stack UnderFlow");
			return;
		} else {
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println("push data");
		stack.display();

		stack.pop();
		System.out.println("pop data");
		stack.display();

		System.out.println("size of the data");
		int size = stack.size();
		System.out.println("size " + size);

		System.out.println("check empty ");
		boolean result = stack.isEmpty();
		if (result == true)
			System.out.println("Not a empty stack");
		else
			System.out.println("empty stack");

		System.out.println("peek data");
		int result1 = stack.peek();
		System.out.println(result1);
	}
}
