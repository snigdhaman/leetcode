package stack;

import java.util.List;
import java.util.Stack;

public class LC636ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();           //0, 1
        int[] res = new int[n];                         //[2, 4]

        int prevProcessStartTime = 0;                   //2
        for (String log : logs) {                   //["0:start:0","1:start:2","1:end:5","0:end:6"]
            String[] el = log.split(":");
            int processID = Integer.valueOf(el[0]);     //0
            String action = el[1];                      //end
            int time = Integer.valueOf(el[2]);          //6

            if (action.equals("start")) {
                if (!stack.isEmpty()) {
                    int pid = stack.peek();
                    res[pid] += time - prevProcessStartTime;
                }
                stack.push(processID);
                prevProcessStartTime = time;
            }
            else {
                int pid = stack.pop();
                res[pid] += time - prevProcessStartTime + 1;    //6 - 2 + 1
                prevProcessStartTime = time + 1;
            }
        }
        return res;
    }
}
