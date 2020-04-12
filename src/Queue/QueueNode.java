package Queue;

public class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data, QueueNode<T> n) {
        this.data = data;
        this.next = n;
    }
}
