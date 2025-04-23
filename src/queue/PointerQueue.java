package queue;

import java.util.Random;

public class PointerQueue<T> {
    private Node<T> Head;
    private Node<T> Tail;
    private int size;

    public PointerQueue() {
        this.Head = null;
        this.Tail = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> p = new Node<>(data);
        if (Head == null) {
            Head = p;
        }
        if (Tail != null) {
            Tail.next = p;
        }
        Tail = p;
        size++;
    }

    public void printList() {
        Node<T> current = Head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public long calculateChecksum() {
        long checksum = 0;
        Node<T> current = Head;
        while (current != null) {
            if (current.data instanceof Number) {
                checksum += ((Number) current.data).longValue();
            }
            current = current.next;
        }
        return checksum;
    }

    public int countSeries() {
        if (Head == null)
            return 0;

        int seriesCount = 1;
        Node<T> current = Head;
        int prevValue = (Integer) current.data;

        while (current.next != null) {
            int currentValue = (Integer) current.next.data;
            if (currentValue < prevValue) {
                seriesCount++;
            }
            prevValue = currentValue;
            current = current.next;
        }

        return seriesCount;
    }

    public void clear() {
        while (Head != null) {
            Node<T> next = Head.next;
            Head.next = null;
            Head = next;
        }
        size = 0;
    }

    public void printForwardRecursive() {
        printForwardRecursiveHelper(Head);
        System.out.println();
    }

    private void printForwardRecursiveHelper(Node<T> current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + " ");
        printForwardRecursiveHelper(current.next);
    }

    public void printBackwardRecursive() {
        printBackwardRecursiveHelper(Head);
        System.out.println();
    }

    private void printBackwardRecursiveHelper(Node<T> current) {
        if (current == null) {
            return;
        }
        printBackwardRecursiveHelper(current.next);
        System.out.print(current.data + " ");
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return Head.data;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private T convertToGeneric(int value) {
        return (T) Integer.valueOf(value);
    }

    public void fillAscending(int n) {
        for (int i = 1; i <= n; i++) {
            enqueue(convertToGeneric(i));
        }
    }

    public void fillDescending(int n) {
        for (int i = n; i >= 1; i--) {
            enqueue(convertToGeneric(i));
        }
    }

    public void fillRandom(int count, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(max - min + 1) + min;
            enqueue(convertToGeneric(num));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = Head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}