package pl.gebert.service;

import org.springframework.stereotype.Service;
import pl.gebert.model.Pair;

import java.util.List;

@Service
public class TaskThreeService {
    public int countSeparatedGraphs(final List<Pair> pairs) {
        Pair previous = null;
        int counter = 0;

        for (Pair currentPair : pairs) {
            if (previous == null) {
                counter++;
                previous = currentPair;
                continue;
            }

            if (hasConnection(previous, currentPair)) {
                previous = currentPair;
            } else {
                counter++;
                previous = null;
            }
        }

        return counter;
    }

    private boolean hasConnection(Pair previous, Pair current) {
        return previous.left().equals(current.left())
                || previous.right().equals(current.right())
                || previous.left().equals(current.right())
                || previous.right().equals(current.left());
    }
}
