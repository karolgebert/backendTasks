package pl.gebert.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskOneServiceTest {

    private final TaskOneService taskOneService = new TaskOneService();

    private final int[] input = {9, 10, 11, 1, 2, 6, 2, 9, 7, 20};

    @Test
    void checkElementsAreInProperOrder() {
        String inOrder = taskOneService.getInOrder(Arrays.stream(input).boxed());

        assertEquals("1 2 6 7 9 10 11 20", inOrder);
    }

    @Test
    void checkCountIsCalculatedProperly() {
        long count = taskOneService.getCount(Arrays.stream(input).boxed());

        assertEquals(10, count);
    }

    @Test
    void checkDistinctIsCalculatedProperly() {
        long distinct = taskOneService.getDistinctCount(Arrays.stream(input).boxed());

        assertEquals(8, distinct);
    }

    @Test
    void checkMinValueIsSelectedCorrectly() {
        int min = taskOneService.getMin(Arrays.stream(input).boxed());

        assertEquals(1, min);
    }

    @Test
    void checkMaxValueIsSelectedCorrectly() {
        int max = taskOneService.getMax(Arrays.stream(input).boxed());

        assertEquals(20, max);
    }
}