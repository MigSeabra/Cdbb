package Services;

import Exceptions.InvalidCallInputException;
import Mappers.CallsMapper;
import Models.CallsInput;

import java.util.List;

public class BillService {

    public Double totalCallsCost(List<String> rawCalls) throws InvalidCallInputException {

        CallsInput calls = CallsMapper.toCallsInput(rawCalls);

        return calls.getTotalCallsCost();
    }
}