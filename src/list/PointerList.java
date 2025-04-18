package list;

public class PointerList<T extends Number> {
    private Node<T> head;
    private int size;

    public PointerList() {
        this.head = null;
        this.size = 0;
    }

    // Добавление элемента в конец списка
    public void append(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = p;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = p;
        }
        size++;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }


    public long checkSum() {
        long sum = 0;
        Node<T> current = head;
        while (current != null) {
            sum += current.data.longValue();
            current = current.next;
        }
        return sum;
    }

    public int countSeries() {
        if (head == null) {
            return 0;
        }

        int seriesCount = 1;
        Node<T> current = head;
        T prevValue = current.data;

        while (current.next != null) {
            current = current.next;
            if (!current.data.equals(prevValue)) {
                seriesCount++;
                prevValue = current.data;
            }
        }
        return seriesCount;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        // Проходим по всем узлам и явно обнуляем ссылки
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.data = null;  // Освобождаем данные
            current.next = null;  // Разрываем связь
            current = next;
        }
        head = null;
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
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