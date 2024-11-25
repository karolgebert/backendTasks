package pl.gebert.service;

import org.springframework.stereotype.Service;

import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class PrinterService {
    private final TaskOneService taskOneService;

    public PrinterService(TaskOneService taskOneService) {
        this.taskOneService = taskOneService;
    }

    public void printTaskOne(Supplier<Stream<Integer>> streamSupplier) {
        print(taskOneService.getInOrder(streamSupplier.get()));
        print("count: " + taskOneService.getCount(streamSupplier.get()));
        print("distinct: " + taskOneService.getDistinctCount(streamSupplier.get()));
        print("min: " + taskOneService.getMin(streamSupplier.get()));
        print("max: " + taskOneService.getMax(streamSupplier.get()));
    }

    private void print(String object) {
        System.out.println(object);
    }
}
