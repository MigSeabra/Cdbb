import Exceptions.InvalidCallInputException;
import Services.BillService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    /**
     * Computes the total cost of a calls list passed as argument and outputs it on console.
     * Calls from calls list must have the following format: time_of_start;time_of_finish;call_from;call_to.
     * Parameter time_of_finish must be greater than time_of_start.
     * @param args Path to the file containing calls list
     */
    public static void main(String ... args) {

        if (args == null || args.length != 1) {
            System.out.println("Invalid input file, please try again");
            System.exit(-1);
        }

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