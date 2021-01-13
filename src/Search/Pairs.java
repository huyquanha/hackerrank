package Search;

import java.util.Arrays;

public class Pairs {
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        int i = 0, j = 1;
        while (j < n) {
            if (arr[j] - arr[i] > k) {
                i++;
            } else if (arr[j] - arr[i] < k) {
                j++;
            } else {
                i++;
                j++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
