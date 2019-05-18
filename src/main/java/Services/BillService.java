package Services;

import Exceptions.InvalidCallInputException;
import Mappers.CallsMapper;
import Models.CallsInput;

import java.util.List;

public class BillService {

    public Double totalCallsCost(List<String> calls) throws InvalidCallInputException {

        CallsInput call = CallsMapper.toCallsInput(calls);



        return 0.0;
    }

}