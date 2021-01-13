package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = k - 1;
        int curUnfairness = arr[j] - arr[i];
        int minUnfairness = curUnfairness;
        while (++j < n) {
            i++;
            curUnfairness = curUnfairness - (arr[i] - arr[i - 1]) + (arr[j] - arr[j-1]);
            if (curUnfairness < minUnfairness) {
                minUnfairness = curUnfairness;
            }
        }
        return minUnfairness;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int minUnfairness = maxMin(k, arr);
        System.out.println(minUnfairness);
    }
}
