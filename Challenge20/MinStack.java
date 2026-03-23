// Challenge to design a stack class that supports the push, pop, top and getMin operations

class MinStack {
    Stack<Integer> stack = new Stack<>(); // Instantiate the main stack
    Stack<Integer> minStack = new Stack<>(); // Instantiate the stack that returns the min value

    public MinStack() {
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) { // If the minStack is empty or the push value is less 
            minStack.push(val); // than the top, I push the value to minStack
        }
        stack.push(val); 
    }
    
    public void pop() {
        int topStack = stack.pop(); 
        if (minStack.peek().equals(topStack)) { // If the pop value is equal than top minStack, pop the minStack 
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek(); 
    }
}