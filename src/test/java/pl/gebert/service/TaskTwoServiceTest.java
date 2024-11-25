package pl.gebert.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTwoServiceTest {

    private final TaskTwoService taskTwoService = new TaskTwoService();

    private final int[] input = {1, 2, 10, 7, 5, 3, 6, 6, 13, 0};

    @Test
    void getPairs() {
        List<TaskTwoService.Pair> pairs = taskTwoService.getPairs(Arrays.stream(input).boxed());

        assertEquals(0, pairs.get(0).left());
        assertEquals(13, pairs.get(0).right());

        assertEquals(3, pairs.get(1).left());
        assertEquals(10, pairs.get(1).right());

        assertEquals(6, pairs.get(2).left());
        assertEquals(7, pairs.get(2).right());

        assertEquals(6, pairs.get(3).left());
        assertEquals(7, pairs.get(3).right());
    }
}