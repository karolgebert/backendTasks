package pl.gebert.service;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.gebert.model.Pair;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskThreeServiceTest {

    private final TaskThreeService taskThreeService = new TaskThreeService();

    @Test
    @DisplayName("Count separated graphs for low depth graph")
    void countSeparatedGraphsLowDepth() {
        List<Pair> pairs = Lists.list(new Pair(4,3), new Pair(1, 4), new Pair(5, 6));

        int count = taskThreeService.countSeparatedGraphs(pairs);

        assertEquals(2, count);
    }

    @Test
    @DisplayName("Count separated graphs for single pair of vertices")
    void countSeparatedGraphsSinglePair() {
        List<Pair> pairs = Lists.list(new Pair(4,3));

        int count = taskThreeService.countSeparatedGraphs(pairs);

        assertEquals(1, count);
    }

    @Test
    @DisplayName("Count separated graphs for high depth graph")
    void countSeparatedGraphsHighDepth() {
        List<Pair> pairs = Lists.list(new Pair(4,3), new Pair(1, 4), new Pair(1, 6), new Pair(6, 5), new Pair(6, 10), new Pair(10, 20));

        int count = taskThreeService.countSeparatedGraphs(pairs);

        assertEquals(1, count);
    }

    @Test
    @DisplayName("Count separated graphs for few single pair graphs")
    void countSeparatedGraphsFewSinglePair() {
        List<Pair> pairs = Lists.list(new Pair(4,3), new Pair(1, 2), new Pair(5, 6), new Pair(7, 8), new Pair(9, 10), new Pair(11, 12));

        int count = taskThreeService.countSeparatedGraphs(pairs);

        assertEquals(6, count);
    }

    @Test
    @DisplayName("Count separated graphs for few single pair graphs when first pair is not connected to anyone")
    void countSeparatedGraphsFewSinglePairNotConnectedFirst() {
        List<Pair> pairs = Lists.list(new Pair(1,2), new Pair(3, 4), new Pair(4, 2));

        int count = taskThreeService.countSeparatedGraphs(pairs);

        assertEquals(2, count);
    }
}