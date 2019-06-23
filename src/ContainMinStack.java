import java.util.Stack;

/**
 * 实现一个能找到栈的最小元素的min函数
 * min push pop的复杂度都是O(1)
 * 思路:利用辅助栈来解决
 */


public class ContainMinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        //直接在栈中添加数据
        stack.push(data);
        //在辅助栈中做出判断,peek查看栈顶元素
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        if (stack.size() == 0) {
            throw new RuntimeException("栈为空");
        }
        int data = stack.pop();
        minStack.pop();
        return data;
    }

    public int min() {
        if (minStack.size() == 0) {
            throw new RuntimeException("栈为空");
        }
        return minStack.peek();
    }
}
