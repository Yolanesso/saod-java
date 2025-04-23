package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
