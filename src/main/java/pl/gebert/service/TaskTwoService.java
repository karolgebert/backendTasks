package pl.gebert.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class TaskTwoService {

    public List<Pair> getPairs(Stream<Integer> integerStream) {
        Set<Integer> diffs = new HashSet<>();
        List<Pair> pairs = new ArrayList<>();

        integerStream
                .forEach(i -> {
                    int diff = 13 - i;
                    if (diffs.contains(diff)) {
                        pairs.add(new Pair(Math.min(i, diff), Math.max(i, diff)));
                    } else {
                        diffs.add(i);
                    }
                });

        pairs.sort(Comparator.comparingInt(a -> a.left));
        return pairs;
    }

    public record Pair(Integer left, Integer right) {
    }
}
