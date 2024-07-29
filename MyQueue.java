public class MyQueue<T> {

    private final MyLinkedList<T> linkedList = new MyLinkedList<>();

    public void push(T item) {
        linkedList.add(item);
    }

    public T pop() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        T firstItem = linkedList.get(0);
        linkedList.delete(0);
        return firstItem;
    }

    public T peek() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        return linkedList.get(0);
    }
}
