import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size = 0;

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }

    public T get(int targetIndex) {
        if (checkValidBounds(targetIndex)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = this.head;
        int currentIndex = 0;
        while (currentIndex < targetIndex) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData();
    }

    public void delete(int targetIndex) {
        if (checkValidBounds(targetIndex)) {
            throw new IndexOutOfBoundsException();
        }

        if (targetIndex == 0) {
            head = head.getNext();
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < targetIndex - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        size--;
    }

    private boolean checkValidBounds(int targetIndex) {
        return targetIndex < 0 || targetIndex >= size;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T data = currentNode.getData();
                currentNode = currentNode.getNext();
                return data;
            }
        };
    }
}