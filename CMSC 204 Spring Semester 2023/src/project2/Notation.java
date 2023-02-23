package project2;

//A utility class that converts an infix expression to a postfix expression, a postfix expression to 
//an infix expression and evaluates a postfix expression.
public class Notation {


	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	private static int operatorToInt(String operator) {
		switch (operator) {
			case "*":
				return 4;
			case "/":
				return 3;
			case "+":
				return 2;
			case "-":
				return 1;
			default:
				return -1;
			
		}
	}
	
	//expand later for other issues
	private static boolean checkValidParentheses(String expression) {
		MyStack<String> stack = new MyStack<>(expression.length());
		
		if (expression.substring(0, 1).equals(")"))
			return false;
		
		for (int i = 0; i < expression.length(); i++) {
			if (expression.substring(i, i+1).equals(")")) {
				if (stack.size() == 0)
					return false;
				while (stack.size() > 1 && !stack.top().equals("(")) {
					stack.pop();
				}
				stack.pop();
			}
			else if (expression.substring(i, i+1).equals("(")) {
				stack.push(expression.substring(i, i+1));
			}
		}

		return stack.size() == 0;
		
	}
	
	private static boolean checkValidPostfix(String expression) {
		//minimum length of postfix expression
		if (expression.length() < 3)
			return false;
		
		if (isInteger(expression.substring(0, 1)) && isInteger(expression.substring(1, 2))) {
			if (expression.substring(expression.length()-1, expression.length()).matches("\\+|-|/|\\*")) {
				int nums = 0;
				int operators = 0;
				for (int i = 0; i < expression.length(); i++) {
					if (isInteger(expression.substring(i, i+1)))
						nums++;
					else if (expression.substring(i, i+1).matches("\\+|-|/|\\*")) {
						operators++;
					}
				}
				if (nums-1 == operators)
					return true;
			}
		}
		return false;
	}
	
	//converts infix notation to postfix notation
	//InvalidNotationFormatException - if the infix expression format is invalid
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		
		if (!checkValidParentheses(infix))
			throw new InvalidNotationFormatException();
		
		MyQueue<String> postfixQueue = new MyQueue<>(infix.length());
		MyStack<String> postfixStack = new MyStack<>(infix.length());
		
		for (int i = 0; i < infix.length(); i++) {
			String current = infix.substring(i, i+1);
			
			if (isInteger(current)) {
				postfixQueue.enqueue(current);
			}
			else if (current.equals("(")) {
				postfixStack.push(current);
			}
			else if (current.matches("\\+|-|\\*|/")) {
				while (postfixStack.size() > 0 && operatorToInt(postfixStack.top()) >= operatorToInt(current)) {
					postfixQueue.enqueue(postfixStack.pop());
				}
				postfixStack.push(current);
			}
			else if (current.equals(")")) {
				while (postfixStack.size() > 0 && !postfixStack.top().equals("(")) {
					postfixQueue.enqueue(postfixStack.pop());
				}
				if (!postfixStack.top().equals("(")) {
					throw new InvalidNotationFormatException();
				}
				postfixStack.pop();
			}
		}
		
		while (postfixStack.size() > 0) {
			postfixQueue.enqueue(postfixStack.pop());
		}

		return postfixQueue.toString();	
	}
	
	//Convert the Postfix expression to the Infix expression
	//InvalidNotationFormatException - if the postfix expression format is invalid
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		if (!checkValidPostfix(postfix))
			throw new InvalidNotationFormatException();
		
		MyStack<String> infixStack = new MyStack<>(postfix.length());
		
		for (int i = 0; i < postfix.length(); i++) {
			String current = postfix.substring(i, i+1);
			
			if (isInteger(current)) {
				infixStack.push(current);
			}
			else if (current.matches("\\+|-|\\*|/")) {
				if (infixStack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				else {
					String elementTwo = infixStack.pop();
					String elementOne = infixStack.pop();
					String expression = "(" + elementOne + current + elementTwo + ")";
					infixStack.push(expression);
				}
			}
		}
		
		if (infixStack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return infixStack.top();
	}
	
	public static double evaluatePostfixExpression(String postfixExpression) throws InvalidNotationFormatException {
		if (!checkValidPostfix(postfixExpression))
			throw new InvalidNotationFormatException();
		
		MyStack<Double> stack = new MyStack<>(postfixExpression.length());
		
		for (int i = 0; i < postfixExpression.length(); i++) {
			String current = postfixExpression.substring(i, i+1);
			
			if (isInteger(current)) {
				stack.push(Double.parseDouble(current));
			}
			else if (current.matches("\\+|-|/|\\*")) {
				if (stack.size() < 2)
					throw new InvalidNotationFormatException();
				
				double rightOperand = stack.pop();
				double leftOperand = stack.pop();
				
				switch (current) {
					case "*":
						stack.push(leftOperand * rightOperand);
						break;
					case "/":
						stack.push(leftOperand / rightOperand);
						break;
					case "+":
						stack.push(leftOperand + rightOperand);
						break;
					case "-":
						stack.push(leftOperand - rightOperand);
				}
				
			}
		}
		
		if (stack.size() > 1)
			throw new InvalidNotationFormatException();
		return stack.top();
		
	}
	
}
