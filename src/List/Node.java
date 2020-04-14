package List;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node n) {
        this.data = data;
        this.next = n;
    }
}