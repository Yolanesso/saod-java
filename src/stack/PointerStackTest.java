package stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointerStackTest {

    @Test
    public void testFillAscending() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.fillAscending(5);

        assertEquals(5, stack.size);
        assertEquals("[5, 4, 3, 2, 1]", stack.toString());
    }

    @Test
    public void testFillDescending() {
        PointerStack<Integer> stack = new PointerStack<>();
        stack.fillDescending(5);

        assertEquals(5, stack.size);
        assertEquals("[1, 2, 3, 4, 5]", stack.toString());
    }

    @Test
    public void testFillRandomSmall() {
        PointerStack<Integer> stack = new PointerStack<>();
        int min = 0, max = 100;
        stack.fillRandom(50, min, max);

        assertEquals(50, stack.size);
        // Проверяем что все числа в диапазоне
        String[] elements = stack.toString().replaceAll("[\\[\\]]", "").split(", ");
        Arrays.stream(elements)
                .mapToInt(Integer::parseInt)
                .forEach(num -> {
                    assertTrue(num >= min && num <= max);
                });
    }
}