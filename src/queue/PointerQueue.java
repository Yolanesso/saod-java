package queue;

import java.util.Random;

public class PointerQueue<T extends Number> {
    public int size;
    private Node<T> front; // начало очереди (отсюда удаляем)
    private Node<T> rear;  // конец очереди (сюда добавляем)

    public PointerQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста!");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }


    // Просмотр первого элемента (peek)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста!");
        }
        return front.data;
    }

    public void fillAscending(int n) {
        for (int i = 1; i <= n; i++) {
            enqueue((T) Integer.valueOf(i));
        }
    }

    public void fillDescending(int n) {
        for (int i = n; i >= 1; i--) {
            enqueue((T) Integer.valueOf(i));
        }
    }

    public void fillRandom(int count, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(max - min + 1) + min;
            enqueue((T) Integer.valueOf(num));
        }
    }

    // Для вывода очереди
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
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