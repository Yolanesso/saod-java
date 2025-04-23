package queue;

import org.junit.jupiter.api.Test;

import stack.PointerStack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        int min = 1;
        int max = 1000;

        queue.fillRandom(count, min, max);

        assertEquals(count, queue.size());

    }

    @Test
    public void testCountSeries() {
        PointerQueue<Integer> queue = new PointerQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.countSeries());
    }

    @Test
    public void testCalculateChecksum() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(60, queue.calculateChecksum());
    }

    @Test
    public void testClearWithFilledStack() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.fillRandom(100, 1, 1000);
        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    public void testPrintForwardRecursive() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        queue.printForwardRecursive();

        String actual = out.toString().replace("\r\n", "\n");
        assertEquals("1 2 3 \n", actual);
    }

    @Test
    public void testPrintBackwardRecursive() {
        PointerQueue<Integer> queue = new PointerQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        queue.printBackwardRecursive();

        String actual = out.toString().replace("\r\n", "\n");
        assertEquals("3 2 1 \n", actual);
    }
}