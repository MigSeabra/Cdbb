package Mappers;

import Exceptions.InvalidCallInputException;
import Models.Call;
import Models.CallsInput;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallsMapper {

    private Pattern p = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2});(\\d{2}):(\\d{2}):(\\d{2});\\+(\\d+);\\+(\\d+)");

    public static CallsInput toCallsInput(List<String> calls) {
        CallsInput resp = new CallsInput();

        if (CollectionUtils.isEmpty(calls)) {
            return resp;
        }



        return resp;
    }

    private Call toCall(String inCall) throws InvalidCallInputException {
        Call resp = null;

        Matcher m = p.matcher(inCall);

        if (!m.matches()) {
            throw new InvalidCallInputException("invalid input call format");
        }

        LocalTime callStartTime = LocalTime.parse(m.group(1));
        LocalTime callEndTime = LocalTime.parse(m.group(2));
        Integer callNumber = Integer.valueOf(m.group(3));
        Integer calledNumber = Integer.valueOf(m.group(4));

        resp = new Call(callStartTime, callEndTime, callNumber, calledNumber);

        return resp;
    }
}
