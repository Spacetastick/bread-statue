package project2;

//put exception classes here, use prev project as example.
//one or all of these need to extend runtime exception, check discord
//each of them individually extends exception

//occurs when a Notation format is incorrect
public class InvalidNotationFormatException {
	//not fully implemented
	public InvalidNotationFormatException() {
		super();
	}
}

//occurs when a top or pop method is called on an empty stack
class StackUnderflowException {
	
}

//occurs when a push method is called on a full stack
class StackOverflowException {
	
}

//occurs when a dequeue method is called on an empty queue.
class QueueUnderflowException {
	
}

//occurs when an enqueue method is called on a full queue
class QueueOverflowException {
	
}