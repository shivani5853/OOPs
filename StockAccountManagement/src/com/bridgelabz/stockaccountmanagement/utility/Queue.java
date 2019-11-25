/******************************************************************************

 *  Purpose: Queue implementation
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

public class Queue<T> {

	Node<T> head;
	
	class Node<T>
	{
		T data;
		Node<T> next;
		
		Node(T data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	/*
	 * Method to add data
	 */
	public void add(T data) {
		Node<T> new_Node = new Node<T>(data);
		if(head==null)
			head=new_Node;
		else {
			Node<T> temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=new_Node;
		}
	}
	
	/*
	 * Method to display data
	 */
	public void display() {
		Node<T> temp=head;
		Integer a=10;
		if(!isEmpty()) {
		while(temp!=null) {
			
			if(!(temp.data.equals(-1))) {
				if((((Integer) temp.data)).compareTo(a)<0){
					System.out.print(temp.data+"  ");
				}
				else
					System.out.print(temp.data+" ");
			}
			else
				System.out.print("   ");
			temp=temp.next;
			}
		System.out.println();
		}
	}
	
	/*
	 * Method to remove data
	 */
	public T remove() {
		Node<T> temp=head;
		if(head!=null)
			head = temp.next;
		return temp.data;
	}
	
	/*
	 * Method to check Empty queue or not
	 */
	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.display();
	}
}
