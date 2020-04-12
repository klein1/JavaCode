package Queue;

public interface IQueue<T> {

    int size();

    void clear();

    boolean isEmpty();

    void enqueue(T x);

    T dequeue();

    T peek();
}
