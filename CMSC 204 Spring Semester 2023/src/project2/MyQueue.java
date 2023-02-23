package project2;

import java.util.ArrayList;

//clean up code this.
//creating queue from scratch, can use arraylist
/**
 * 
 * @author Noah Cil
 *
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {
	
	private int capacity;
	private final int defaultCapacity = 10; //check if this needs to be a specific size
	private int size = 0; //change if necessary
	private ArrayList<T> queue;
	
	public MyQueue(int capacity) {
		this.capacity = capacity;
		this.queue = new ArrayList<>(capacity);
	}
	
	public MyQueue() {
		this.capacity = defaultCapacity;
		this.queue = new ArrayList<>(defaultCapacity);
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean isFull() {
		return this.size == capacity;
	}

	public T dequeue() throws QueueUnderflowException {
		if (size == 0)
			throw new QueueUnderflowException();
		else {
			T temp = this.queue.get(0);
			this.queue.remove(0);
			this.size--;
			
			return temp;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean enqueue(T e) throws QueueOverflowException {
		if (size == capacity)
			throw new QueueOverflowException();
		else {
			this.queue.add(e);
			this.size++;
			
			return true;
		}
	}
	
	//might have to change this
	public String toString() {
		String output = "";
		for (T e : queue) {
			output += e;
		}
		
		return output;
	}
	
	public String toString(String delimiter) {
		String output = "";
		for (T e : queue) {
			output += e + delimiter;
		}
		
		return output.substring(0, output.length()-1);
	}
	
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		@SuppressWarnings("all")
		ArrayList<T> clonedList = (ArrayList<T>) list.clone();
		
		for (int i = 0; i < clonedList.size(); i++) {
			if (size == capacity) {
				throw new QueueOverflowException();
			}
			else {
				this.queue.add(clonedList.get(i));
				size++;
			}
		}
		
		
	}
	
}
