package Models;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CallsInput {

    private List<Call> callList;

    public void addCall(Call call) {
        if (this.callList == null) {
            this.callList = new ArrayList<>();
        }
        this.callList.add(call);
    }

    public Double getTotalCallsCost() {
        Double totalCost = 0.0;

        if (CollectionUtils.isEmpty(callList)) {
            return totalCost;
        }

        Call maxDurCall = Collections.max(callList, Comparator.comparingLong(Call::getDuration));

       // this.callList.stream().filter(!))

        return totalCost;
    }

    public List<Call> getCallList() {
        return callList;
    }

    public void setCallList(List<Call> callList) {
        this.callList = callList;
    }
}
