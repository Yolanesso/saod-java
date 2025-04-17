package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointerQueueTest {


    @Test
    public void testFillAscending() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.fillAscending(5);

        assertEquals("[1, 2, 3, 4, 5]", queue.toString());
        assertEquals(1, queue.peek());
    }

    @Test
    public void testFillDescending() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.fillDescending(5);

        assertEquals("[5, 4, 3, 2, 1]", queue.toString());
        assertEquals(5, queue.peek());
    }


    @Test
    public void testFillRandom() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.fillRandom(10, 0, 100);
        assertEquals(10, queue.size());
    }
}