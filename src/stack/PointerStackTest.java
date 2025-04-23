package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PointerStackTest {

    @Test
    public void testFillAscending() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.fillAscending(5);

        assertEquals(5, stack.size());
        assertEquals("[5, 4, 3, 2, 1]", stack.toString());
    }

    @Test
    public void testFillDescending() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.fillDescending(5);

        assertEquals(5, stack.size());
        assertEquals("[1, 2, 3, 4, 5]", stack.toString());
    }

    @Test
    public void testFillRandom() {
        PointerStack<Integer> stack = new PointerStack<>();
        int count = 100;
        int min = 0, max = 1000;
        stack.fillRandom(count, min, max);

        assertEquals(count, stack.size());

    }

    @Test
    public void testPrintList() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        String expected = "[1, 2, 3]";
        assertEquals(expected, stack.toString());

    }

    @Test
    public void testCalculateChecksum() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(60, stack.calculateChecksum());
    }

    @Test
    public void testCountSeries() {
        PointerStack<Integer> stack = new PointerStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.countSeries());

        stack = new PointerStack<>();
        stack.fillAscending(5); // 5 4 3 2 1
        assertEquals(5, stack.countSeries());

        stack = new PointerStack<>();
        stack.fillDescending(5); // 1 2 3 4 5
        assertEquals(1, stack.countSeries());
    }

    @Test
    public void testClearWithFilledStack() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.fillRandom(100, 1, 1000);
        stack.clear();
        assertEquals(0, stack.size());
    }

    @Test
    public void testPrintForward() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        stack.printForward();

        assertEquals("1 2 3 \n", out.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testPrintBackward() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        stack.printBackward();

        assertEquals("3 2 1 \n", out.toString().replace("\r\n", "\n"));
    }

}
