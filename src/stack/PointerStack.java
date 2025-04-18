package stack;

import java.util.Random;

public class PointerStack<T extends Number> {
    private Node<T> Head;
    private int size;

    public PointerStack() {
        this.Head = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> p = new Node<>(data);
        p.next = Head;
        Head = p;
        size++;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public int size() {
        return size;
    }

    public void fillAscending(int n) {
        for (int i = 1; i <= n; i++) {
            push(convertToGeneric(i));
        }
    }

    public void fillDescending(int n) {
        for (int i = n; i >= 1; i--) {
            push(convertToGeneric(i));
        }
    }

    public void fillRandom(int count, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(max - min + 1) + min;
            push(convertToGeneric(num));
        }
    }

    @SuppressWarnings("unchecked")
    private T convertToGeneric(int value) {
        return (T) Integer.valueOf(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = Head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
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