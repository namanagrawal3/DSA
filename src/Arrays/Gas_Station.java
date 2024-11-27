package Arrays;

public class Gas_Station {
    public static void main(String[] args) {
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int curr_gas = 0;
        int idx = 0;

        for (int i = 0; i < gas.length; i++) {
            total_gas += gas[i] - cost[i];
            curr_gas += gas[i] - cost[i];

            if (curr_gas < 0) {
                idx = i + 1;
                curr_gas = 0;
            }
        }

        if (total_gas < 0)
            return -1;
        return idx;
    }
}
