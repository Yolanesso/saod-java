package stack;

import java.util.Random;

public class PointerStack<T extends Number> {
    public int size;
    private Node<T> top;

    public PointerStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void fillAscending(int n) {
        for (int i = 1; i <= n; i++) {
            push((T) Integer.valueOf(i));
        }
    }

    public void fillDescending(int n) {
        for (int i = n; i >= 1; i--) {
            push((T) Integer.valueOf(i));
        }
    }

    public void fillRandom(int count, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(max - min + 1) + min;
            push((T) Integer.valueOf(num));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
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