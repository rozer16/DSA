package j_stack;

import java.util.Stack;

/*
*
* TC : O(N)
* SC : O(2N)
*
* */
class H_A_MinValueFromStack<T extends Comparable<T>>{
	Stack<T> stack = new Stack<>();
	Stack<T> stackBkp = new Stack<>();
	
	public T peekMin() {
		return stackBkp.peek();
	}
	
	public void push(T t) {
		if(stack.isEmpty()) {
			stack.push(t);
			stackBkp.push(t);
		}else {
			if(t.compareTo(stack.peek()) < 0) {
				stackBkp.push(t);
			}
			stack.push(t);
		}
	}
	
	
	public T pop() {
		if(stack.isEmpty()) {
			return null;
		}
		T t = stack.pop();
		if(t.compareTo(stackBkp.peek()) == 0) {
			stackBkp.pop();
		}
		return t;
	}
	
	public static void main(String[] args) {
		 H_A_MinValueFromStack<Integer> stack = new H_A_MinValueFromStack<Integer>();
		 stack.push(6);
		 stack.push(5);
		System.out.println(stack.peekMin());
		 stack.push(4);
		System.out.println(stack.peekMin());
		 stack.pop();
		System.out.println(stack.peekMin());
		 stack.push(2);
		 System.out.println(stack.stack);
		 System.out.println(stack.stackBkp);
	}
}