package pl.gebert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.gebert.service.PrinterService;

import java.util.stream.Stream;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final PrinterService service;

    @Autowired
    public MyCommandLineRunner(PrinterService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.printTaskOne(() -> Stream.of(args).map(Integer::valueOf));
    }
}
