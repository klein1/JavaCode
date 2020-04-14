package Stack;

public interface IStack<T> {

    int size();

    void clear();

    boolean isEmpty();

    void push(T item);

    T pop();

    T peek();
}
