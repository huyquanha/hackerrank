package Search;

import java.util.Scanner;

public class MinimumTimeRequired {
    static long minTime(long[] machines, long goal) {
        // find the fastest machine
        long fastest = Long.MAX_VALUE;
        long slowest = Long.MIN_VALUE;
        int n = machines.length;
        for (int i = 0; i < n; i++) {
            if (machines[i] > slowest) {
                slowest = machines[i];
            }
            if (machines[i] < fastest) {
                fastest = machines[i];
            }
        }
        System.out.println(fastest);
        System.out.println(slowest);
        // find the lowerbound, established by fastest
        long lo = (long) Math.ceil((double) goal / n) * fastest;
        System.out.println(lo);
        // find the upperbound, established by slowest
        long hi = (long) Math.ceil((double) goal / n) * slowest;
        System.out.println(hi);
        long currentMin = hi;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            // calculate how many items can be done in mid days
            long items = 0;
            for (int i = 0; i < n; i++) {
                items += mid / machines[i]; // automatically truncated to long
            }
            if (items > goal) {
                hi = mid - 1;
            } else if (items < goal) {
                lo = mid + 1;
            } else {
                // we have to be careful not to return mid immediately here
                // since we may even achieve the goal in a shorter amount of days than mid
                if (mid < currentMin) currentMin = mid;
                hi = mid - 1;
            }
        }
        // sometimes we might not get the goal exactly at all, so currentMin
        // is still equal the original hi. When re finish the loop, we can guarantee
        // to produce goal in lo days, so we take the minimum of the 2
        return Math.min(currentMin, lo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long goal = scanner.nextLong();
        scanner.nextLine(); // skip the line
        long[] machines = new long[n];
        String[] machineItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            machines[i] = Long.parseLong(machineItems[i]);
        }
        System.out.println(minTime(machines, goal));
    }
}
