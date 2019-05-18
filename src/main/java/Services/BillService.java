package Services;

import Exceptions.InvalidCallInputException;
import Mappers.CallsMapper;
import Models.CallsInput;

import java.util.List;

public class BillService {
    /**
     * Parses and computes the total cost of a calls list passed as argument
     * @param rawCalls Calls list as a list of Strings
     * @return Calls total cost as a Double
     * @throws InvalidCallInputException in case of invalid input calls list
     */
    public Double totalCallsCost(List<String> rawCalls) throws InvalidCallInputException {

        CallsInput calls = CallsMapper.toCallsInput(rawCalls);

        return calls.getTotalCallsCost();
    }
}