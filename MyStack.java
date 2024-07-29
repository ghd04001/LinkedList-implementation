public class MyStack<T> {

    private final MyLinkedList<T> linkedList = new MyLinkedList<>();

    public void push(T item) {
        linkedList.add(item);
    }

    public T pop() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("empty stack");
        }

        int lastIndex = linkedList.getSize() - 1;
        T top = linkedList.get(lastIndex);
        linkedList.delete(lastIndex);
        return top;
    }

    public T peek() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("empty stack");
        }
        return linkedList.get(linkedList.getSize() - 1);
    }
}
