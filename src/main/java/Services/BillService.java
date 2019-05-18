package Services;

import Mappers.CallsMapper;
import Models.CallsInput;

import java.util.List;

public class BillService {

    public Double totalCallsCost(List<String> calls) {

        CallsInput callsInput = CallsMapper.toCallsInput(calls);


        return 0.0;
    }

}