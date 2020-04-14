package Stack;

public class LinkedStack<T> implements IStack<T> {

    private StackNode<T> top;

    public LinkedStack() {
        this.top = null;
    }

    @Override
    public int size() {
        int size = 0;
        StackNode temp = this.top;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    @Override
    public void clear() {
        while(!isEmpty())
            pop();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void push(T item) {
        if(item != null){
            this.top = new StackNode<T>(item, this.top);
        }
    }

    @Override
    public T pop() {
        if(isEmpty())
            return null;
        T temp = this.top.data;
        this.top = this.top.next;
        return temp;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : this.top.data;
    }
}
