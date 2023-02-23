package project2;

import java.util.ArrayList;

//probably backwards
public class MyStack<T> implements StackInterface<T> {
	private int capacity;
	private final int defaultCapacity = 10; //check if this needs to be a specific size
	private int size = 0; //change if necessary
	private ArrayList<T> stack;
	
	public MyStack(int capacity) {
		this.capacity = capacity;
		this.stack = new ArrayList<>(capacity);
	}
	
	public MyStack() {
		this.capacity = defaultCapacity;
		this.stack = new ArrayList<>(defaultCapacity);
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean isFull() {
		return this.size == capacity;
	}

	public T pop() throws StackUnderflowException {
		if (size == 0)
			throw new StackUnderflowException();
		else {
			T temp = this.stack.get(0);
			this.stack.remove(0);
			this.size--;
			
			return temp;
		}
	}
	
	public T top() throws StackUnderflowException {
		if (size == 0)
			throw new StackUnderflowException();
		else
			return stack.get(0);
	}
	
	public int size() {
		return size;
	}
	
	public boolean push(T e) throws StackOverflowException {
		if (size == capacity)
			throw new StackOverflowException();
		else {
			this.stack.add(0, e);
			this.size++;
			
			return true;
		}
	}
	
	//might have to change this
	public String toString() {
		String output = "";
		for (int i = stack.size()-1; i >= 0; i--) {
			output += stack.get(i);
		}
		
		return output;
	}
	
	public String toString(String delimiter) {
		String output = "";
		for (int i = stack.size()-1; i >= 0; i--) {
			output += stack.get(i) + delimiter;
		}
		
		return output.substring(0, output.length()-1);
	}
	
	public void fill(ArrayList<T> list) throws StackOverflowException {
		@SuppressWarnings("all")
		ArrayList<T> clonedList = (ArrayList<T>) list.clone();
		
		for (int i = 0; i < clonedList.size(); i++) {
			if (size == capacity) {
				throw new StackOverflowException();
			}
			else {
				this.stack.add(0, clonedList.get(i));
				size++;
			}
		}
		
		
	}
	
	
}
