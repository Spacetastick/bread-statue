//replace all direct access with getters and setters

package project3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public DoubleLinkedListIterator<T> iterator() {
		//this method returns an object of the doublelinkedlistiterator
		//(the inner class that implements java's listiterator interface)
		return new DoubleLinkedListIterator<T>(head);
	}
	
	public void addToEnd(T data) {
		//BOTH POINT TO THE SAME ELEMENT WHEN THERE IS ONLY ONE ELEMENT IN THE LIST
		Node temp = new Node(data);
		if (tail == null) {
			tail = temp;
			head = temp;
			tail.prev = head;
			head.next = tail;
		}
		else {
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		tail.next = null;
		
		size++;
	}
	
	public void addToFront(T data) {
		//BOTH POINT TO THE SAME ELEMEMNT WHEN THERE IS ONLY ONE ELEMENT IN THE LIST
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
			tail = temp;
			head.next = tail;
			tail.prev = head;
		}
		else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		head.prev = null;
		
		size++;
	}
	
	public T getFirst() {
		if (size == 0)
			return null;
		if (head == null)
			return tail.data; //come back to this later maybe
		return head.data; //come back to this later maybe
	}
	
	public T getLast() {
		if (size == 0)
			return null;
		if (tail == null)
			return head.data; //come back to this later maybe
		return tail.data; //come back to this later maybe
	}
	
	public int getSize() {
		return size;
	}
	
	public Node remove(T targetData, Comparator<T> comparator) {
		//removes the first instance of the targetData from the list
		//notice that you must remove the elements by performing a single traversal over the list. you may not use any
		//of the other retrieval methods associated with the class in order to complete the removal process. you must
		//use the provided comparator (do not use equals) to find those elements that match the target. do not
		//implement this method using iterators
		
		DoubleLinkedListIterator<T> iterator = this.iterator();
		
		do {
			T data = iterator.next();
			if (comparator.compare(targetData, data) == 0) {
				Node<T> temp = iterator.cursor;
				
				if (temp.prev != null && temp.next != null) {
					temp.prev.setNext(temp.next);
					temp.next.setPrev(temp.prev);
					temp.prev = null;
					temp.next = null;
				}
				else if (temp.prev != null) {
					temp.prev.setNext(null);
					temp.prev = null;
				}
				else if (temp.next != null) {
					temp.next.setPrev(null);
					temp.next = null;
				}
				
				return temp;
			}
		} while (iterator.hasNext());
		return null;
		
	}
	
	public T retrieveFirstElement() {
		//removes and returns the first element from the list
		//if there are no elements the method returns null. do not implement this method using iterators
		if (size == 0)
			return null;
		
		T data = head.data;
		head.next.setPrev(null);
		head.setNext(null);
		
		return data;
		
	}
	
	public T retrieveLastElement() {
		//removes and returns the last element from the list
		//if there are no elements the method returns null. do not implement this method using iterators
		
		if (size == 0)
			return null;
		
		T data = tail.data;
		tail.prev.setNext(null);
		tail.setPrev(null);
		
		return data;
	}
	
	public ArrayList<T> toArrayList() {
		//returns an arraylist of all the items in the double linked list
		DoubleLinkedListIterator<T> iterator = this.iterator();
		ArrayList<T> linkedAsArray = new ArrayList<T>();
		
		while (iterator.hasNext()) {
			linkedAsArray.add(iterator.next());
		}
			
		
		return linkedAsArray;
		
	}
	
	
	
	public class DoubleLinkedListIterator<T> implements ListIterator<T> {
		//a generic inner class named doublelinkedlistiterator that implements java's listiterator interface
		//(for the iterator method)
		
		//you need at least one attribute for this class that can be initialized to the head of the
		//basicdoublelinklist in order to implement the methods of this class
		
		protected Node<T> cursor;
		protected int index;
		//private Node prev; //clarify name maybe
		//private Node next; //clarify name maybe
		
		public DoubleLinkedListIterator(Node<T> head) {
			//constructor to initialize the current pointer to the head of the BasicDoubleLinkedList
			//the other attributes defined for this class can be initialized as well
			cursor = head;
			index = 0;
//			prev = null;
//			next = tail;
			
		}

//		public Node<T> getCursor() {
//			return cursor;
//		}
		
		@Override
		public boolean hasNext() {
			//use index if issues
//			return cursor.next != null;
			return index < size;
		}

		@Override
		public T next() throws NoSuchElementException {
			if (cursor.next == null)
				throw new NoSuchElementException();
			T data = cursor.data;
			cursor = cursor.next;
			index++;
			return data;
		}

		@Override
		public boolean hasPrevious() {
//			return cursor.prev != null;
			return index > 0;
		}

		@Override
		public T previous() throws NoSuchElementException {
			if (cursor.prev == null)
				throw new NoSuchElementException();
			T data = cursor.data;
			cursor = cursor.prev;
			index--;
			return data;
		}

		//not used
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		//not used
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		//not used
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();	
		}

		//not used
		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		//not used
		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
	
	
	
	public class Node<T> {
		//a generic inner class node - this class has the following attributes:
		
		protected T data;
		protected Node<T> prev;
		protected Node<T> next;
		
		//make sure this works if private, may not work with junit tests
		public Node(T dataNode) {
			data = dataNode;
		}
		
		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
	}
	
	
	
}
