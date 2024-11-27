package pl.gebert.service;

import org.springframework.stereotype.Service;
import pl.gebert.model.Pair;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PrinterService {
    private final TaskOneService taskOneService;
    private final TaskTwoService taskTwoService;
    private final TaskThreeService taskThreeService;

    public PrinterService(TaskOneService taskOneService, TaskTwoService taskTwoService, TaskThreeService taskThreeService) {
        this.taskOneService = taskOneService;
        this.taskTwoService = taskTwoService;
        this.taskThreeService = taskThreeService;
    }

    public void printMenu() {
        print("Please select task number and press <enter>");
        print("1. Task One");
        print("2. Task Two");
        print("3. Task Three");
    }

    public void printWrongInputError() {
        print("Wrong input. Please provide proper input.");
    }

    public void printTaskOneResult(Supplier<Stream<Integer>> streamSupplier) {
        print(taskOneService.getInOrder(streamSupplier.get()));
        print("count: " + taskOneService.getCount(streamSupplier.get()));
        print("distinct: " + taskOneService.getDistinctCount(streamSupplier.get()));
        print("min: " + taskOneService.getMin(streamSupplier.get()));
        print("max: " + taskOneService.getMax(streamSupplier.get()));
    }

    public void printTaskTwoResult(Supplier<Stream<Integer>> streamSupplier) {
        List<Pair> pairs = taskTwoService.getPairs(streamSupplier.get());
        pairs.forEach(pair -> {
            print(pair.left().toString() + " " + pair.right());
        });
    }

    public void printTaskThreeResult(Supplier<Stream<Pair>> streamSupplier) {
        long count = taskThreeService.countSeparatedGraphs(streamSupplier.get().collect(Collectors.toList()));

        print(String.valueOf(count));
    }

    private void print(String object) {
        System.out.println(object);
    }
}
