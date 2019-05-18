import Services.BillService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String ... args) {

        BillService billService = new BillService();

        List<String> calls = null;

        try {
            calls = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Reading from file failed: " + e.getMessage());
        }

        System.out.println(billService.totalCallsCost(calls));
    }
}
