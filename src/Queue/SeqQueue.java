package Queue;

public class SeqQueue<T> implements IQueue<T> {

    private static final int DEFAULT_CAPACITY = 64;
    private static final int GROW_FACTOR = 2;
    private Object[] element;
    private int head, tail;
    private int capacity;

    public SeqQueue() {
        this(DEFAULT_CAPACITY);
    }

    public SeqQueue(int capacity) {
        assert capacity != 0;
        this.element = new Object[Math.abs(capacity)];
        this.head = this.tail = 0;
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return (this.tail - this.head + this.capacity) % this.capacity;
    }

    @Override
    public void clear() {
        this.head = this.tail = 0;
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return this.head == (this.tail + 1) % this.capacity;
    }

    @Override
    public void enqueue(T x) {
        if (x == null)
            return;
        if (isFull()) {
            Object[] newer = new Object[this.capacity * GROW_FACTOR];
            int i = this.head, j = 0;
            while (i != this.tail) {
                newer[j] = this.element[i];
                i = (i + 1) % this.capacity;
                j++;
            }
            this.element = newer;
            this.capacity = newer.length;
            this.head = 0;
            this.tail = j;
        }
        this.element[this.tail] = x;
        this.tail = (this.tail + 1) % this.capacity;

    }

    @Override
    public T dequeue() {
        if (isEmpty())
            return null;
        @SuppressWarnings("unchecked")
        T temp = (T) this.element[head];
        this.head = (this.head + 1) % this.capacity;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        @SuppressWarnings("unchecked")
        T temp = (T) this.element[head];
        return temp;
    }
}
