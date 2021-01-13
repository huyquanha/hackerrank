package Greedy;

import java.util.Arrays;

public class MinAbsoluteDifference {
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i-1];
            if (diff < minDiff) minDiff = diff;
        }
        return minDiff;
    }
}
