package Queue;

public class LinkedQueue<T> implements IQueue<T> {

    private QueueNode<T> head;
    private QueueNode<T> tail;

    public LinkedQueue() {
        this.head = this.tail = null;
    }

    @Override
    public int size() {
        int size = 0;
        QueueNode temp = this.head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            dequeue();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    @Override
    public void enqueue(T x) {
        if (x == null)
            return;
        QueueNode<T> q = new QueueNode<T>(x, null);
        if (this.head == null)
            this.head = q;
        else
            this.tail.next = q;
        this.tail = q;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            return null;
        T temp = this.head.data;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return this.head.data;
    }
}
