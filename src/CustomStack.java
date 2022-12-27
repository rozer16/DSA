import java.util.Stack;




class CustomStack<T extends Comparable<T>>{
	Stack<T> stack = new Stack<>();
	Stack<T> stackBkp = new Stack<>();
	
	public T peekMax() {
		return stackBkp.peek();
	}
	
	public void push(T t) {
		if(stack.isEmpty()) {
			stack.push(t);
			stackBkp.push(t);
		}else {
			if(t.compareTo(stack.peek()) >= 0) {
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
		 CustomStack<Integer> stack = new CustomStack<Integer>();
		 stack.push(1);
		 stack.push(5);
		 stack.push(4);
		 stack.pop();
		 stack.peekMax();
		 stack.push(2);
		 System.out.println(stack.stack);
		 System.out.println(stack.stackBkp);
	}
}