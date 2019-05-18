package Mappers;

import Exceptions.InvalidCallInputException;
import Models.Call;
import Models.CallsInput;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallsMapper {
    /**
     * Converts String calls list to CallsInput model
     * @param calls Calls list as a list of Strings
     * @return CallsInput model
     * @throws InvalidCallInputException in case of invalid input calls list
     */
    public static CallsInput toCallsInput(List<String> calls) throws InvalidCallInputException {
        CallsInput resp = new CallsInput();

        if (CollectionUtils.isEmpty(calls)) {
            return resp;
        }

        for (String call : calls) {
            resp.addCall(toCall(call));
        }

        return resp;
    }

    /**
     * Converts a single call from String to Call model representation
     * @param inCall String representation of call
     * @return Call model
     * @throws InvalidCallInputException in case of invalid input call String
     */
    private static Call toCall(String inCall) throws InvalidCallInputException {
        Pattern p = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2});(\\d{2}):(\\d{2}):(\\d{2});\\+(\\d+);\\+(\\d+)");
        Matcher m = p.matcher(inCall);

        if (!m.matches()) {
            throw new InvalidCallInputException("invalid input call format");
        }

        LocalTime callStartTime = LocalTime.parse(m.group(1) + ":" + m.group(2) + ":" + m.group(3));
        LocalTime callEndTime = LocalTime.parse(m.group(4) + ":" + m.group(5) + ":" + m.group(6));
        Long callNumber = Long.valueOf(m.group(7));
        Long calledNumber = Long.valueOf(m.group(8));

        if (callStartTime.compareTo(callEndTime) >= 0) {
            throw new InvalidCallInputException("call end time must be greater than call start time");
        }

        Long callDuration = callStartTime.until(callEndTime, ChronoUnit.SECONDS);

        return new Call(callStartTime, callEndTime, callNumber, calledNumber, callDuration);
    }
}