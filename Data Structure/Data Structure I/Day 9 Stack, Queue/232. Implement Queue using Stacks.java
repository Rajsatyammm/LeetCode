// 232. Implement Queue using Stacks

class MyQueue {

    public Stack<Integer> s;
    public MyQueue() {
        s = new Stack<>();
    }
    
    public void pushAtBottom(int x) {
        if(s.isEmpty()) {
            s.push(x);
            return;
        }
        int val = s.pop();
        pushAtBottom(x);
        s.push(val);
    }

    public void push(int x) {
        pushAtBottom(x);
    }
    
    public int pop() {
        return s.pop();
    }
    
    public int peek() {
        return s.peek();
    }
    
    public boolean empty() {
        return s.size() == 0;
    }
}
