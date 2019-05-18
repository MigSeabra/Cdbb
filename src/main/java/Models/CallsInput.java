package Models;

import java.util.ArrayList;
import java.util.List;

public class CallsInput {

    private List<Call> callList;

    public void addCall(Call call) {
        if (this.callList == null) {
            this.callList = new ArrayList<>();
        }
        this.callList.add(call);
    }

    public List<Call> getCallList() {
        return callList;
    }

    public void setCallList(List<Call> callList) {
        this.callList = callList;
    }
}
