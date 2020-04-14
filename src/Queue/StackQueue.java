package Queue;
import java.util.Stack;

public class StackQueue<E> {
    private Stack<E> stack1; // 入队
    private Stack<E> stack2; // 出队

    public StackQueue() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

    public void push(E e) {
        stack1.push(e);
    }

    /**
     * 先检查stack2是否为空：
     * 若为空，先将stack1中的元素全部倒回stack2，再对stack2执行弹栈操作
     * 否则，则直接对stack2执行弹栈操作
     */
    public E pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
