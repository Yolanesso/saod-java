package queue;

import java.util.Random;

public class PointerQueue<T> {
    private Node<T> Head; // Начало очереди
    private Node<T> Tail; // Конец очереди
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