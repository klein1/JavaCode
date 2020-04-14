package Stack;

import java.util.Arrays;

public class SeqStack<T> implements IStack<T> {

    private static final int DEFAULT_CAPACITY = 64;
    private static final int GROW_FACTOR = 2;
    private Object element[];
    private int top;
    private int capacity;

    public SeqStack() {
        this(DEFAULT_CAPACITY);
    }

    public SeqStack(int capacity){
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity too small.");
        this.element = new Object[Math.abs(capacity)];
        this.top = -1;
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public void clear() {
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.capacity - 1;
    }

    @Override
    public void push(T item) {
        if(item == null)
            return;
        if(isFull()){
            this.capacity *= GROW_FACTOR;
            this.element = Arrays.copyOf(this.element, this.capacity);
        }
        this.top++;
        this.element[this.top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            return null;
        @SuppressWarnings("unchecked")
        T temp = (T) this.element[this.top--];
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        @SuppressWarnings("unchecked")
        T temp = (T) this.element[this.top];
        return temp;
    }
}
