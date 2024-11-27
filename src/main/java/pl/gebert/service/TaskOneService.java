package pl.gebert.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TaskOneService {
    public String getInOrder(Stream<Integer> integerStream) {
        return integerStream
                .sorted()
                .distinct()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public long getCount(Stream<Integer> integerStream) {
        return integerStream
                .count();
    }

    public long getDistinctCount(Stream<Integer> integerStream) {
        return integerStream
                .distinct()
                .count();
    }

    public Integer getMin(Stream<Integer> integerStream) {
        return integerStream
                .distinct()
                .min(Integer::compareTo).orElseThrow();
    }

    public Integer getMax(Stream<Integer> integerStream) {
        return integerStream
                .distinct()
                .max(Integer::compareTo).orElseThrow();
    }
}
