package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointerQueueTest {

    @Test
    public void testFillAscending() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        int count = 5;

        queue.fillAscending(count);

        assertEquals(count, queue.size());
        assertEquals("[1, 2, 3, 4, 5]", queue.toString());

    }

    @Test
    public void testFillDescending() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        int count = 5;

        queue.fillDescending(count);

        assertEquals(count, queue.size());
        assertEquals("[5, 4, 3, 2, 1]", queue.toString());

    }

    @Test
    public void testFillRandom() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        int count = 100;
        int min = 10;
        int max = 50;

        queue.fillRandom(count, min, max);

        assertEquals(count, queue.size());

    }
}