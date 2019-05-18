import Exceptions.InvalidCallInputException;
import Services.BillService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String ... args) {

        BillService billService = new BillService();

        try {
            List<String> calls = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
            Double totalCost = billService.totalCallsCost(calls);
            System.out.println(totalCost);
        } catch (IOException e) {
            System.out.println("Reading from file failed: " + e.getMessage());
        } catch (InvalidCallInputException e) {
            System.out.println("Error parsing file: " + e.getMessage());
        }
    }
}