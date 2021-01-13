package DynamicProgramming;

import java.util.Scanner;

public class MaxArraySum {
    static int max(int... array) {
        int max = Integer.MIN_VALUE;
        for (int a : array) {
            if (a > max) max = a;
        }
        return max;
    }

    static int maxSubsetSum(int[] arr) {
        int result = 0;
        int n = arr.length;
        // max of subset that ends at each element
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                max[i] = arr[i];
            } else if (i == 2) {
                if (arr[i] >= 0) {
                    max[i] = Math.max(max[i - 2], 0) + arr[i];
                } else {
                    max[i] = Math.max(max[i-2], arr[i]);
                }
            } else {
                if (arr[i] >= 0) {
                    max[i] = max(max[i-2], max[i-3], 0) + arr[i];
                } else {
                    max[i] = max(max[i-2], max[i-3], arr[i]);
                }
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] a = new int[n];
        String[] items = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(items[i]);
        }
        System.out.println(maxSubsetSum(a));
    }
}
