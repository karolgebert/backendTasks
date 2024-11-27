package pl.gebert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.gebert.model.Pair;
import pl.gebert.service.PrinterService;

import java.util.*;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final PrinterService service;
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    @Autowired
    public MyCommandLineRunner(PrinterService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.printMenu();
        int selectedOption = scanner.nextInt();
        try {
            if (List.of(1, 2, 3).contains(selectedOption)) {
                switch (selectedOption) {
                    case 1:
                        service.askUserForInput(1, "Space separated integers: ");
                        String taskOneInput = scanner.next();
                        service.printTaskOneResult(() -> Arrays.stream(taskOneInput.split("\\s+")).map(Integer::parseInt));
                        break;
                    case 2:
                        service.askUserForInput(2, "Space separated integers: ");
                        String taskTwoInput = scanner.next();
                        service.printTaskTwoResult(() -> Arrays.stream(taskTwoInput.split("\\s+")).map(Integer::parseInt));
                        break;
                    case 3:
                        List<Pair> pairs = new ArrayList<>();
                        service.askUserForInput(3, "Number of lines: ");
                        int count = scanner.nextInt();
                        for (int i = 0; i < count; i++) {
                            service.askUserForInput(3, String.format("Space separated pair %s: ", i + 1));
                            String taskThreeInput = scanner.next("\\d+\\s+\\d+");
                            String[] split = taskThreeInput.split("\\s+");
                            pairs.add(new Pair(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
                        }
                        service.printTaskThreeResult(pairs::stream);
                        break;
                }
            } else {
                service.printWrongInputError();
            }
        } catch (Exception e) {
            service.printWrongInputError();
        } finally {
            scanner.close();
        }
    }
}
