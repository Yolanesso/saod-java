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
            checksum += current.data.longValue();
            current = current.next;
        }
        return checksum;
    }

    public int countSeries() {
        if (Head == null) {
            return 0;
        }

        int seriesCount = 1;
        Node<T> current = Head;
        T prev = Head.data;

        while (current != null) {
            if (current.data.doubleValue() < prev.doubleValue()) {
                seriesCount++;
            }
            prev = current.data;
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

    public void printForward() {
        printForwardRecursive(Head);
        System.out.println();
    }

    private void printForwardRecursive(Node<T> current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + " ");
        printForwardRecursive(current.next);
    }

    public void printBackward() {
        printBackwardRecursive(Head);
        System.out.println();
    }

    private void printBackwardRecursive(Node<T> current) {
        if (current == null) {
            return;
        }
        printBackwardRecursive(current.next);
        System.out.print(current.data + " ");
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