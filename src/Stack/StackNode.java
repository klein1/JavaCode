package Stack;

public class StackNode<T> {
    T data;
    StackNode<T> next;

    public StackNode(T data, StackNode<T> n) {
        this.data = data;
        this.next = n;
    }
}
