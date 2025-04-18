package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointerListTest {

    @Test
    public void testPrintList() {
        PointerList<Integer> list = new PointerList<>();
        list.append(1);
        list.append(2);
        list.append(3);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testCheckSum() {
        PointerList<Integer> list = new PointerList<>();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        assertEquals(100, list.checkSum());

    }

    @Test
    public void testCountSeries() {
        PointerList<Integer> list = new PointerList<>();
        assertEquals(0, list.countSeries());

        list.append(5);
        assertEquals(1, list.countSeries());

        list.append(5);
        list.append(5);
        list.append(3);
        list.append(3);
        list.append(8);
        assertEquals(3, list.countSeries());

        PointerList<Integer> uniqueList = new PointerList<>();
        uniqueList.append(1);
        uniqueList.append(2);
        uniqueList.append(3);
        assertEquals(3, uniqueList.countSeries());
    }

}